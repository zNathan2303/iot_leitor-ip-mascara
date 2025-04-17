package br.sp.senai.jandira.model;

public class IpInfo {

	private String ipCidr;
	private String ip;
	private int cidr;
	private String classe;
	private String mascaraDecimal;
	private String mascaraBinaria;
	private int quantidadeIps;
	
	public void setIpCidr(String ipCidr) {
		this.ipCidr = ipCidr;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getCidr() {
		return cidr;
	}

	public void setCidr(int cidr) {
		this.cidr = cidr;
	}

	public String getClasse() {
		return classe;
	}

	public String getMascaraDecimal() {
		return mascaraDecimal;
	}

	public String getMascaraBinaria() {
		return mascaraBinaria;
	}

	public void setMascaraBinaria(String mascaraBinaria) {
		this.mascaraBinaria = mascaraBinaria;
	}

	public int getQuantidadeIps() {
		return quantidadeIps;
	}

	public void setQuantidadeIps(int quantidadeIps) {
		this.quantidadeIps = quantidadeIps;
	}
	
	// separar o id e cidr dados pelo usuario para facilitar os calculos
	public void separarIpCidr() {
		
		String[] temp = ipCidr.split("/");
		ip = temp[0];
		
		cidr = Integer.parseInt(temp[1]);
		
	}

	public void calcularClasse() {

		String[] octetos = ip.split("\\.");
		int primeiroOcteto = Integer.parseInt(octetos[0]);

		if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
			classe = "Classe A";
		} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
			classe = "Classe B";
		} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
			classe = "Classe C";
		} else {
			classe = "Valor inválido!";
		}

	}

	public void calcularMascaraDecimal() {

		int[] octeto = { 0, 0, 0, 0 };
		int[] valoresOcteto = { 0, 0, 0, 0 };
		int[] binario = { 1, 2, 4, 8, 16, 32, 64, 128 };
		int contador = 0;
		int valorDecimal = 0;
		int aux = 8;

		// atribuir os bits aos octetos
		if (cidr >= 1 && cidr <= 32) {

			while (octeto[contador] < 8 && cidr != 0) {

				octeto[contador]++;
				cidr--;

				if (octeto[contador] == 8) {
					contador++;
				}

			}

			// zerar o contador
			contador = 0;

			// transformar os bits em decimal
			while (octeto[contador] > 0) {

				valorDecimal = valorDecimal + binario[aux - 1];
				aux--;
				octeto[contador]--;

				if (octeto[contador] == 0) {
					valoresOcteto[contador] = valorDecimal;
					valorDecimal = 0;
					aux = 8;
					contador++;
				}

				if (octeto[0] == 0 && octeto[1] == 0 && octeto[2] == 0 && octeto[3] == 0) {
					contador = 3;
				}

			}

			mascaraDecimal = valoresOcteto[0] + "." + valoresOcteto[1] + "." + valoresOcteto[2] + "." + valoresOcteto[3];

		} else {

			mascaraDecimal = "Valor inválido!";

		}

	}
	
	public void calcularMascaraBinaria() {
		
	}

}
