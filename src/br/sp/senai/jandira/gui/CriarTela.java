package br.sp.senai.jandira.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.sp.senai.jandira.model.Ip;
import br.sp.senai.jandira.model.Mascara;

public class CriarTela {

	private JLabel labelIpCidr;
	private JTextField textOcteto1;
	private JTextField textOcteto2;
	private JTextField textOcteto3;
	private JTextField textOcteto4;
	private JTextField textCidr;
	private JButton buttonIpInfo;
	private JButton buttonLimpar;
	private JLabel labelIp;
	private JLabel labelCidr;
	private JLabel labelClasse;
	private JLabel labelMascaraDecimal;
	private JLabel labelMascaraBinaria;
	private JLabel labelIpsDisponiveis;
	private JLabel labelSubRedes;

	public void criarTela() {

		JFrame tela = new JFrame();
		tela.setSize(400, 500);
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

		textOcteto1 = new JTextField();
		textOcteto1.setBounds(20, 70, 40, 30);
		
		textOcteto2 = new JTextField();
		textOcteto2.setBounds(70, 70, 40, 30);
		
		textOcteto3 = new JTextField();
		textOcteto3.setBounds(120, 70, 40, 30);
		
		textOcteto4 = new JTextField();
		textOcteto4.setBounds(170, 70, 40, 30);
		
		textCidr = new JTextField();
		textCidr.setBounds(220, 70, 40, 30);

		buttonIpInfo = new JButton();
		buttonIpInfo.setText("Mostrar informações");
		buttonIpInfo.setBounds(20, 110, 160, 30);

		buttonLimpar = new JButton();
		buttonLimpar.setText("Limpar");
		buttonLimpar.setBounds(200, 110, 160, 30);
		
		labelIp = new JLabel();
		labelIp.setText("IP: ");
		labelIp.setBounds(20, 150, 460, 30);
		
		labelCidr = new JLabel();
		labelCidr.setText("CIDR: ");
		labelCidr.setBounds(20, 190, 460, 30);
		
		labelClasse = new JLabel();
		labelClasse.setText("Classe do IP: ");
		labelClasse.setBounds(20, 230, 460, 30);
		
		labelMascaraDecimal = new JLabel();
		labelMascaraDecimal.setText("Máscara decimal: ");
		labelMascaraDecimal.setBounds(20, 270, 460, 30);
		
		labelMascaraBinaria = new JLabel();
		labelMascaraBinaria.setText("Máscara binária: ");
		labelMascaraBinaria.setBounds(20, 310, 460, 30);
		
		labelIpsDisponiveis = new JLabel();
		labelIpsDisponiveis.setText("Total de IPs disponíveis: ");
		labelIpsDisponiveis.setBounds(20, 350, 460, 30);
		
		labelSubRedes = new JLabel();
		labelSubRedes.setText("Sub-redes: ");
		labelSubRedes.setBounds(20, 390, 460, 30);
		
		tela.getContentPane().add(labelIpCidr);
		tela.getContentPane().add(textOcteto1);
		tela.getContentPane().add(textOcteto2);
		tela.getContentPane().add(textOcteto3);
		tela.getContentPane().add(textOcteto4);
		tela.getContentPane().add(textCidr);
		tela.getContentPane().add(buttonIpInfo);
		tela.getContentPane().add(buttonLimpar);
		tela.getContentPane().add(labelIp);
		tela.getContentPane().add(labelCidr);
		tela.getContentPane().add(labelClasse);
		tela.getContentPane().add(labelMascaraDecimal);
		tela.getContentPane().add(labelMascaraBinaria);
		tela.getContentPane().add(labelIpsDisponiveis);
		tela.getContentPane().add(labelSubRedes);
		
		buttonIpInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				Ip ipInfo = new Ip();
				ipInfo.setIp(textOcteto1.getText());

				Mascara mask = new Mascara();
				mask.setCidrString(textOcteto1.getText());

				ipInfo.pegarIp();
				mask.pegarCidr();
				mask.calcularTotalIps();

				labelIp.setText("IP: " + ipInfo.pegarIp());
				labelCidr.setText("CIDR: " + mask.pegarCidr());
				labelClasse.setText("Classe do IP: " + ipInfo.calcularClasse());
				labelMascaraDecimal.setText("Máscara decimal: " + mask.calcularMascaraDecimal());
				labelMascaraBinaria.setText("Máscara binária: " + mask.calcularMascaraBinaria());
				labelIpsDisponiveis.setText("Total de IPs disponíveis: " + mask.getQuantidadeIps());
				labelSubRedes.setText("Sub-redes: " + ipInfo.calcularSubRedes());
				
			}
		});
		
		buttonLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textOcteto1.setText(null);
				labelIp.setText("IP: ");
				labelCidr.setText("CIDR: ");
				labelClasse.setText("Classe do IP: ");
				labelMascaraDecimal.setText("Máscara decimal: ");
				labelMascaraBinaria.setText("Máscara binária: ");
				labelIpsDisponiveis.setText("Total de IPs disponíveis: ");
				labelSubRedes.setText("Sub-redes: ");
				
			}
		});
		
		tela.setVisible(true);
		
	}

}
