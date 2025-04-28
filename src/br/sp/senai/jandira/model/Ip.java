package br.sp.senai.jandira.model;

public class Ip {

	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String calcularClasse() {

			int primeiroOcteto = Integer.parseInt(ip);

			if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
				return "Classe A";
			} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
				return "Classe B";
			} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
				return "Classe C";
			} else {
				return "Erro! O primeiro octeto do IP precisa ir de 0 até 223!";
			}

	}

	public String calcularSubRedes() {

			int primeiroOcteto = Integer.parseInt(ip);

			if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
				return "8";
			} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
				return "16";
			} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
				return "24";
			} else {
				return "Erro! O primeiro octeto do IP precisa ir de 0 até 223!";
			}

	}

}
