package br.sp.senai.jandira.model;

public class Mascara {
	
	private int cidr;
	private String quantidadeIps;

	public int getCidr() {
		return cidr;
	}

	public void setCidr(int cidr) {
		this.cidr = cidr;
	}

	public String getQuantidadeIps() {
		return quantidadeIps;
	}

	public String calcularMascaraDecimal() {

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

			return valoresOcteto[0] + "." + valoresOcteto[1] + "." + valoresOcteto[2] + "."
					+ valoresOcteto[3];

		} else {

			return "CIDR inválido!";

		}

	}

	public String calcularMascaraBinaria() {

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

			return valoresOcteto[0] + " " + valoresOcteto[1] + " " + valoresOcteto[2] + " "
					+ valoresOcteto[3];

		} else {

			return "CIDR inválido!";

		}

	}

	public void calcularTotalIps() {

		int quantidadeIpsTemp = cidr;
		if (quantidadeIpsTemp >= 1 && quantidadeIpsTemp <= 30) {

			// é preciso definir a quantidade de ips quando o cidr é 1 pois o máximo que um
			// tipo int
			// é capaz de guardar é 2147483647, e acaba dando erro quando vai subtrair 2 dos
			// ips
			if (quantidadeIpsTemp == 1) {
				quantidadeIps = "2147483646";
			}

			// para ter ips disponiveis, o cidr precisa ser no máximo de 30
			if (quantidadeIpsTemp > 1 && quantidadeIpsTemp <= 30) {
				quantidadeIps = String.valueOf((int) Math.pow(2, 32 - quantidadeIpsTemp) - 2);
			}

		} else {
			quantidadeIps = "O CIDR precisa ir de 1 até 30 para ter ips disponíveis!";
		}

	}

}
