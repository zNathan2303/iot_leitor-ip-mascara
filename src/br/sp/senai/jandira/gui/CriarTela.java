package br.sp.senai.jandira.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.sp.senai.jandira.model.IpInfo;

public class CriarTela {
	
	private JLabel labelIpCidr;
	private JTextField textIpCidr;
	private JButton buttonIpInfo;
	private JButton buttonLimpar;
	private JLabel labelIp;
	private JLabel labelClasse;
	private JLabel labelMascaraDecimal;
	private JLabel labelMascaraBinaria;
	private JLabel labelIpsDisponiveis;

	public void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setSize(500, 400);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Informações da rede");
		
		// define onde o jframe irá ficar na tela, como é null então
		// centraliza na tela
		tela.setLocationRelativeTo(null);
		
		// faz com que tenha que definir manualmente a posição e tamanho dos
		// objetos dentro do jframe
		tela.setLayout(null);
		
		tela.setResizable(false);
		
		labelIpCidr = new JLabel();
		labelIpCidr.setText("Digite um IP com CIDR (ex: 192.168.0.0/24):");
		labelIpCidr.setBounds(20, 30, 460, 30);
		
		textIpCidr = new JTextField();
		textIpCidr.setBounds(20, 70, 450, 30);
		
		buttonIpInfo = new JButton();
		buttonIpInfo.setText("Mostrar informações");
		buttonIpInfo.setBounds(20, 110, 220, 30);

		buttonLimpar = new JButton();
		buttonLimpar.setText("Limpar");
		buttonLimpar.setBounds(250, 110, 220, 30);
		
		labelIp = new JLabel();
		labelIp.setText("IP: ");
		labelIp.setBounds(20, 150, 460, 30);
		
		labelClasse = new JLabel();
		labelClasse.setText("Classe do IP: ");
		labelClasse.setBounds(20, 190, 460, 30);
		
		labelMascaraDecimal = new JLabel();
		labelMascaraDecimal.setText("Máscara decimal: ");
		labelMascaraDecimal.setBounds(20, 230, 460, 30);
		
		labelMascaraBinaria = new JLabel();
		labelMascaraBinaria.setText("Máscara binária: ");
		labelMascaraBinaria.setBounds(20, 270, 460, 30);
		
		labelIpsDisponiveis = new JLabel();
		labelIpsDisponiveis.setText("Total de IPs disponíveis: ");
		labelIpsDisponiveis.setBounds(20, 310, 460, 30);
		
		tela.getContentPane().add(labelIpCidr);
		tela.getContentPane().add(textIpCidr);
		tela.getContentPane().add(buttonIpInfo);
		tela.getContentPane().add(buttonLimpar);
		tela.getContentPane().add(labelIp);
		tela.getContentPane().add(labelClasse);
		tela.getContentPane().add(labelMascaraDecimal);
		tela.getContentPane().add(labelMascaraBinaria);
		tela.getContentPane().add(labelIpsDisponiveis);
		
		buttonIpInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				IpInfo ipInfo = new IpInfo();
				ipInfo.setIpCidr(textIpCidr.getText());
				
				ipInfo.separarIpCidr();
				ipInfo.calcularClasse();
				ipInfo.calcularMascaraDecimal();
				ipInfo.calcularMascaraBinaria();
				ipInfo.calcularTotalIps();
				
				labelIp.setText("IP: " + ipInfo.getIp());
				labelClasse.setText("Classe do IP: " + ipInfo.getClasse());
				labelMascaraDecimal.setText("Máscara decimal: " + ipInfo.getMascaraDecimal());
				labelMascaraBinaria.setText("Máscara binária: " + ipInfo.getMascaraBinaria());
				labelIpsDisponiveis.setText("Total de IPs disponíveis: " + ipInfo.getQuantidadeIps());
				
			}
		});
		
		buttonLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				labelIp.setText("IP: ");
				labelClasse.setText("Classe do IP: ");
				labelMascaraDecimal.setText("Máscara decimal: ");
				labelMascaraBinaria.setText("Máscara binária: ");
				labelIpsDisponiveis.setText("Total de IPs disponíveis: ");
				
			}
		});
		
		tela.setVisible(true);
		
	}
	
	/*
	Scanner leitor = new Scanner(System.in);
	IpInfo ipInfo = new IpInfo();

	public void pegarDados() {

		System.out.print("Digite um IP com CIDR (ex: 192.168.0.0/24): ");
		ipInfo.setIpCidr(leitor.next());
		leitor.close();

	}

	public void mostrarDados() {
		
		ipInfo.separarIpCidr();
		ipInfo.calcularClasse();
		ipInfo.calcularMascaraDecimal();
		ipInfo.calcularMascaraBinaria();
		ipInfo.calcularTotalIps();

		System.out.println("----- INFORMAÇÕES DA REDE -----");
		System.out.println("IP: " + ipInfo.getIp());
		System.out.println("Classe do IP: " + ipInfo.getClasse());
		System.out.println("Máscara (decimal): " + ipInfo.getMascaraDecimal());
		System.out.println("Máscara (binária): " + ipInfo.getMascaraBinaria());
		System.out.println("Total de IPs disponíveis: " + ipInfo.getQuantidadeIps());
		

	}
	*/

}
