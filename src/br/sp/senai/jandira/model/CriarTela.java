package br.sp.senai.jandira.model;

import java.util.Scanner;

public class CriarTela {

	// classes que vão ser usadas
	Scanner leitor = new Scanner(System.in);
	IpInfo ipInfo = new IpInfo();

	public void pegarDados() {

		// pegar as informações do usuário
		System.out.print("Digite um IP (ex: 192.168.0.0): ");
		ipInfo.setIp(leitor.next());

		System.out.print("Digite uma máscara CIDR (ex: 24): ");
		ipInfo.setCidr(leitor.nextInt());

		leitor.close();

	}

	public void mostrarDados() {
		
		ipInfo.calcularClasse();
		ipInfo.calcularMascaraDecimal();

		// mostrar os dados na tela
		System.out.println("----- INFORMAÇÕES DA REDE -----");
		System.out.println("IP: " + ipInfo.getIp());
		System.out.println("Classe do IP: " + ipInfo.getClasse());
		System.out.println("Máscara (decimal): " + ipInfo.getMascaraDecimal());
		System.out.println("Máscara (binária): ");
		System.out.println("Total de IPs disponíveis: ");

	}

}
