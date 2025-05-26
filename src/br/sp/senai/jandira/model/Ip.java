package br.sp.senai.jandira.model;

import java.util.Iterator;

public class Ip {

	private String ip;
	private int cidr;
	private String classe;
	private String mascaraDecimal;
	private String mascaraBinaria;
	private String quantidadeIps;
	private String subRedes;

	public String getSubRedes() {
		return subRedes;
	}

	public String getMascaraDecimal() {
		return mascaraDecimal;
	}

	public String getMascaraBinaria() {
		return mascaraBinaria;
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

	public String getQuantidadeIps() {
		return quantidadeIps;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void calcularClasse() {

		String[] octetos = ip.split("\\.");
		int primeiroOcteto = Integer.parseInt(octetos[0]);;

		if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
			classe = "Classe A";
		} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
			classe = "Classe B";
		} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
			classe = "Classe C";
		} else if (primeiroOcteto >= 224 && primeiroOcteto <= 239) {
			classe = "Classe D";
		} else if (primeiroOcteto >= 240 && primeiroOcteto <= 255) {
			classe = "Classe E";
		}

	}

	public void calcularSubRedes() {

		if (cidr < 24) {
			subRedes = "não implementado cálculo com cidr abaixo de 24";
		}

		if (cidr == 24) {
			subRedes = "Não há sub-redes";
		}
		
		if (cidr > 24) {
			int bitsInativos = 32 - cidr;
			int bitsAtivos = 8 - bitsInativos;

			int numeroDeRede = (int) Math.pow(2, bitsAtivos);
			int numeroDeHost = ((int) Math.pow(2, bitsInativos)) - 2;

			int[] binario = { 128, 64, 32, 16, 8, 4, 2, 1 };
			int salto = 0;

			for (int i = 0; i < bitsAtivos; i++) {
				salto += binario[i];
			}

			salto = 256 - salto;

			subRedes = "Há " + String.valueOf(numeroDeRede) + " sub-redes!";
			System.out.println("sub-rede, IP da sub-rede, intervalo de hosts, IP de broadcast");
			int identificadorHost = 0;
			String[] octetos = ip.split("\\.");
			String rede = octetos[0] + "." + octetos[1] + "." + octetos[2] + ".";
			
			for (int i = 1; i <= numeroDeRede; i++) {
				
				System.out.print(i);
				System.out.print(", ");
				
				System.out.print(rede + identificadorHost);
				System.out.print(", ");
				
				identificadorHost++;
				System.out.print(rede + identificadorHost);
				identificadorHost--;
				System.out.print(" - ");
				identificadorHost += numeroDeHost;
				System.out.print(rede + identificadorHost);
				System.out.print(", ");
				
				identificadorHost++;
				System.out.println(rede + identificadorHost);
				
				identificadorHost++;
				
			}

		}

	}

	public void calcularMascaraDecimal() {

		int[] octeto = { 0, 0, 0, 0 };
		int[] valoresOcteto = { 0, 0, 0, 0 };
		int[] binario = { 1, 2, 4, 8, 16, 32, 64, 128 };
		int contador = 0;
		int valorDecimal = 0;
		int aux = 8;
		int cidrTemp = cidr;

		if (cidrTemp >= 1 && cidrTemp <= 32) {
			// atribuir os bits aos octetos
			while (octeto[contador] < 8 && cidrTemp != 0) {

				octeto[contador]++;
				cidrTemp--;

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

			mascaraDecimal = valoresOcteto[0] + "." + valoresOcteto[1] + "." + valoresOcteto[2] + "."
					+ valoresOcteto[3];

		}

	}

	public void calcularMascaraBinaria() {

		int[] octeto = { 0, 0, 0, 0 };
		String[] valoresOcteto = { "", "", "", "" };
		int contador = 0;
		String valorBinario = "";
		int cidrTemp = cidr;

		// atribuir os bits aos octetos
		if (cidrTemp >= 1 && cidrTemp <= 32) {

			while (octeto[contador] < 8 && cidrTemp != 0) {

				octeto[contador]++;
				cidrTemp--;

				if (octeto[contador] == 8) {
					contador++;
				}

			}

			// responsavel por auxiliar na adição dos zeros
			contador = 3;
			int[] temp = { 0, 0, 0, 0 };

			while (contador > -1) {
				temp[contador] = octeto[contador];
				contador--;
			}

			// zerar o contador
			contador = 0;

			// transformar os bits em binario
			while (octeto[contador] > 0) {

				valorBinario = valorBinario + "1";
				octeto[contador]--;

				// passagem para o próximo octeto
				if (octeto[contador] == 0) {

					// adicionar os zeros no octeto
					if (temp[contador] < 8) {

						int contadorBinario = 8 - temp[contador];

						while (contadorBinario > 0) {
							valorBinario = valorBinario + "0";
							contadorBinario--;
						}

					}

					valoresOcteto[contador] = valorBinario;
					valorBinario = "";
					contador++;
				}

				if (octeto[0] == 0 && octeto[1] == 0 && octeto[2] == 0 && octeto[3] == 0) {
					contador = 3;
				}

			}

			// estrutura responsavel por atribuir os zeros para os octetos sem bits ativos
			if (valoresOcteto[1] == "") {
				valoresOcteto[1] = "00000000";
				valoresOcteto[2] = "00000000";
				valoresOcteto[3] = "00000000";
			}

			if (valoresOcteto[2] == "") {
				valoresOcteto[2] = "00000000";
				valoresOcteto[3] = "00000000";
			}

			if (valoresOcteto[3] == "") {
				valoresOcteto[3] = "00000000";
			}

			mascaraBinaria = valoresOcteto[0] + " " + valoresOcteto[1] + " " + valoresOcteto[2] + " "
					+ valoresOcteto[3];

		}

	}

	public void calcularTotalIps() {

		int quantidadeIpsTemp = cidr;
		if (quantidadeIpsTemp >= 1 && quantidadeIpsTemp <= 30) {

			// é preciso definir a quantidade de ips quando o cidr é 1 pois o máximo que um
			// tipo int é capaz de guardar é 2147483647, e acaba dando erro quando vai
			// subtrair 2 dos ips
			if (quantidadeIpsTemp == 1) {
				quantidadeIps = "2147483646";
			}

			// para ter ips disponiveis, o cidr precisa ser no máximo de 30
			if (quantidadeIpsTemp > 1 && quantidadeIpsTemp <= 30) {
				quantidadeIps = String.valueOf((int) Math.pow(2, 32 - quantidadeIpsTemp) - 2);
			}

		}

	}

}
