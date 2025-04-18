package br.sp.senai.jandira.model;

import java.util.Scanner;

public class CriarTela {

	// classes que vão ser usadas
	Scanner leitor = new Scanner(System.in);
	IpInfo ipInfo = new IpInfo();

	public void pegarDados() {

		// pegar as informações do usuário
		System.out.print("Digite um IP com CIDR (ex: 192.168.0.0/24): ");
		ipInfo.setIpCidr(leitor.next());
		leitor.close();

	}

	public void mostrarDados() {
		
		ipInfo.separarIpCidr();
		ipInfo.calcularClasse();
		ipInfo.calcularMascaraDecimal();
		ipInfo.calcularMascaraBinaria();

		// mostrar os dados na tela
		System.out.println("----- INFORMAÇÕES DA REDE -----");
		System.out.println("IP: " + ipInfo.getIp());
		System.out.println("Classe do IP: " + ipInfo.getClasse());
		System.out.println("Máscara (decimal): " + ipInfo.getMascaraDecimal());
		System.out.println("Máscara (binária): " + ipInfo.getMascaraBinaria());
		System.out.println("Total de IPs disponíveis: ");

	}

}
