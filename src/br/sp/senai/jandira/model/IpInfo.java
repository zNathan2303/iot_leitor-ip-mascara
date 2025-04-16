package br.sp.senai.jandira.model;

public class IpInfo {

	private String ip;
	private int cidr;
	private String classe;
	private String mascaraDecimal;
	private String mascaraBinaria;
	private int quantidadeIps;

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

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getMascaraDecimal() {
		return mascaraDecimal;
	}

	public void setMascaraDecimal(String mascaraDecimal) {
		this.mascaraDecimal = mascaraDecimal;
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

	public void calcularClasse() {

		String[] octetos = ip.split("\\.");
		int primeiroOcteto = Integer.parseInt(octetos[0]);

		if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
			classe = "A";
		} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
			classe = "B";
		} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
			classe = "C";
		} else {
			classe = "Valor inválido!";
		}

	}

	public void calcularMascaraDecimal() {

		int[] octeto = { 0, 0, 0, 0 };
		int[] binario = { 1, 2, 4, 8, 16, 32, 64, 128 };
		int contador = 0;
		int valorDecimal = 0;

		// atribuir os bytes aos octetos
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

			// transformar os bytes em decimal
			while (octeto[contador] > 0) {

				valorDecimal = valorDecimal + binario[octeto[contador] - 1];
				octeto[contador]--;

				if (octeto[contador] == 0) {
					octeto[contador] = valorDecimal;
					valorDecimal = 0;
					contador++;
				}

				if (octeto[0] == 0 && octeto[1] == 0 && octeto[2] == 0 && octeto[3] == 0) {
					contador = 3;
				}

			}

			mascaraDecimal = octeto[0] + "." + octeto[1] + "." + octeto[2] + "." + octeto[3];

		} else {

			mascaraDecimal = "Valor inválido!";

		}

	}

}
