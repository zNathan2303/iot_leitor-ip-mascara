package br.sp.senai.jandira.model;

public class Ip {

	private String ip;
	private String classe;
	private String subRedes;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	// separar o id e cidr dados pelo usuario para facilitar os calculos
	public String pegarIp() {
		
		boolean validar;
		try {
			String[] temp = ip.split("/");
			validar = true;
		} catch(Exception e) {
			validar = false;
		}

		if (validar) {
			String[] temp = ip.split("/");
			ip = temp[0];
			return ip;

		} else {
			return "Erro! Não foi digitado uma barra!";
		}
		
	}

	public String calcularClasse() {
		
		boolean validar;
		try {
			String[] octetos = ip.split("\\.");
			validar = true;
		} catch(Exception e) {
			validar = false;
		}
		
		if (validar) {
			
			String[] octetos = ip.split("\\.");
			int primeiroOcteto = Integer.parseInt(octetos[0]);

			if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
				return "Classe A";
			} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
				return "Classe B";
			} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
				return "Classe C";
			} else {
				return "Erro! O primeiro octeto do IP precisa ir de 0 até 223!";
			}
			
		} else {
			
			return "Erro! O IP precisa ter pontos separado os octetos!";
			
		}

		

	}
	
	public String calcularSubRedes() {
		
		boolean validar;
		try {
			String[] octetos = ip.split("\\.");
			validar = true;
		} catch(Exception e) {
			validar = false;
		}
		
		if (validar) {
			
			String[] octetos = ip.split("\\.");
			int primeiroOcteto = Integer.parseInt(octetos[0]);

			if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
				return subRedes = "8";
			} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
				return subRedes = "16";
			} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
				return subRedes = "24";
			} else {
				return subRedes = "Erro! O primeiro octeto do IP precisa ir de 0 até 223!";
			}
			
		} else {
			
			return classe = "Erro! O IP precisa ter pontos separado os octetos!";
			
		}
		
		
	}
	
	

}
