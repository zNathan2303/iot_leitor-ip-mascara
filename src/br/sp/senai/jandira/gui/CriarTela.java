package br.sp.senai.jandira.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.sp.senai.jandira.model.Ip;

public class CriarTela {

	private JLabel labelIpCidr;
	private JTextField textOcteto1;
	private JLabel labelPonto1;
	private JTextField textOcteto2;
	private JLabel labelPonto2;
	private JTextField textOcteto3;
	private JLabel labelPonto3;
	private JTextField textOcteto4;
	private JLabel labelBarra;
	private JTextField textCidr;
	private JButton buttonIpInfo;
	private JButton buttonLimpar;
	private JLabel labelMensagemErro;
	private JLabel labelIp;
	private JLabel labelCidr;
	private JLabel labelClasse;
	private JLabel labelMascaraDecimal;
	private JLabel labelMascaraBinaria;
	private JLabel labelIpsDisponiveis;
	private JLabel labelSubRedes;
	private JList listaSubredes;
	private JScrollPane scrollSubRedes;

	public void criarTela() {

		JFrame tela = new JFrame();
		tela.setSize(395, 800);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Informações da rede");

		// define onde o jframe irá ficar na tela, como é null então
		// centraliza na tela
		tela.setLocationRelativeTo(null);

		// faz com que tenha que definir manualmente a posição e tamanho dos
		// objetos dentro do jframe
		tela.setLayout(null);

		tela.setResizable(false);

		Font fonteResultado = new Font("Arial", Font.BOLD, 12);

		labelIpCidr = new JLabel();
		labelIpCidr.setText("Digite um IP com CIDR (ex: 192.168.0.0/24):");
		labelIpCidr.setBounds(20, 20, 450, 30);
		labelIpCidr.setFont(new Font("Arial", Font.PLAIN, 16));

		textOcteto1 = new JTextField();
		textOcteto1.setBounds(20, 60, 50, 40);
		textOcteto1.setFont(new Font("Arial", Font.PLAIN, 20));
		textOcteto1.setHorizontalAlignment(JTextField.CENTER);

		labelPonto1 = new JLabel();
		labelPonto1.setText(".");
		labelPonto1.setBounds(73, 60, 50, 40);
		labelPonto1.setFont(new Font("Arial", Font.PLAIN, 48));

		textOcteto2 = new JTextField();
		textOcteto2.setBounds(90, 60, 50, 40);
		textOcteto2.setFont(new Font("Arial", Font.PLAIN, 20));
		textOcteto2.setHorizontalAlignment(JTextField.CENTER);

		labelPonto2 = new JLabel();
		labelPonto2.setText(".");
		labelPonto2.setBounds(143, 60, 50, 40);
		labelPonto2.setFont(new Font("Arial", Font.PLAIN, 48));

		textOcteto3 = new JTextField();
		textOcteto3.setBounds(160, 60, 50, 40);
		textOcteto3.setFont(new Font("Arial", Font.PLAIN, 20));
		textOcteto3.setHorizontalAlignment(JTextField.CENTER);

		labelPonto3 = new JLabel();
		labelPonto3.setText(".");
		labelPonto3.setBounds(213, 60, 50, 40);
		labelPonto3.setFont(new Font("Arial", Font.PLAIN, 48));

		textOcteto4 = new JTextField();
		textOcteto4.setBounds(230, 60, 50, 40);
		textOcteto4.setFont(new Font("Arial", Font.PLAIN, 20));
		textOcteto4.setHorizontalAlignment(JTextField.CENTER);

		labelBarra = new JLabel();
		labelBarra.setText("/");
		labelBarra.setBounds(290, 60, 20, 40);
		labelBarra.setFont(new Font("Arial", Font.PLAIN, 50));

		textCidr = new JTextField();
		textCidr.setBounds(315, 60, 50, 40);
		textCidr.setFont(new Font("Arial", Font.PLAIN, 20));
		textCidr.setHorizontalAlignment(JTextField.CENTER);

		buttonIpInfo = new JButton();
		buttonIpInfo.setText("Mostrar info");
		buttonIpInfo.setBounds(20, 110, 160, 40);
		buttonIpInfo.setFont(new Font("Arial", Font.PLAIN, 20));

		buttonLimpar = new JButton();
		buttonLimpar.setText("Limpar");
		buttonLimpar.setBounds(200, 110, 160, 40);
		buttonLimpar.setFont(new Font("Arial", Font.PLAIN, 20));

		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(0, 110, 385, 380);
		labelMensagemErro.setFont(new Font("Arial", Font.BOLD, 13));
		labelMensagemErro.setForeground(Color.red);
		labelMensagemErro.setHorizontalAlignment(SwingConstants.CENTER);
		labelMensagemErro.setVerticalAlignment(SwingConstants.CENTER);

		// LABELS DE RESULTADO
		labelIp = new JLabel();
		labelIp.setText("IP: ");
		labelIp.setBounds(20, 160, 460, 30);
		labelIp.setFont(fonteResultado);

		labelCidr = new JLabel();
		labelCidr.setText("CIDR: ");
		labelCidr.setBounds(20, 200, 460, 30);
		labelCidr.setFont(fonteResultado);

		labelClasse = new JLabel();
		labelClasse.setText("Classe do IP: ");
		labelClasse.setBounds(20, 240, 460, 30);
		labelClasse.setFont(fonteResultado);

		labelMascaraDecimal = new JLabel();
		labelMascaraDecimal.setText("Máscara decimal: ");
		labelMascaraDecimal.setBounds(20, 280, 460, 30);
		labelMascaraDecimal.setFont(fonteResultado);

		labelMascaraBinaria = new JLabel();
		labelMascaraBinaria.setText("Máscara binária: ");
		labelMascaraBinaria.setBounds(20, 320, 460, 30);
		labelMascaraBinaria.setFont(fonteResultado);

		labelIpsDisponiveis = new JLabel();
		labelIpsDisponiveis.setText("Total de IPs disponíveis: ");
		labelIpsDisponiveis.setBounds(20, 360, 460, 30);
		labelIpsDisponiveis.setFont(fonteResultado);

		labelSubRedes = new JLabel();
		labelSubRedes.setText("Sub-redes: ");
		labelSubRedes.setBounds(20, 400, 460, 30);
		labelSubRedes.setFont(fonteResultado);

		// Criação do modelo de lista que é necessário para atribuir informações de
		// forma indireta para o JList, já que não é possível colocá-las diretamente
		// nele
		DefaultListModel<String> modeloLista = new DefaultListModel<>();
		// Cria e associa o JList ao modelo de lista criado anteriormente, para que tudo
		// dentro do modelo apareça diretamente no JList
		listaSubredes = new JList<>(modeloLista);
		// Coloca a JList dentro de um painel com rolagem, para que caso ela fique muito
		// grande possa ter um scroll para visualizar as informações que passarem dos
		// limites dela
		scrollSubRedes = new JScrollPane(listaSubredes);
		scrollSubRedes.setBounds(20, 440, 340, 300);

		tela.getContentPane().add(labelIpCidr);
		tela.getContentPane().add(textOcteto1);
		tela.getContentPane().add(labelPonto1);
		tela.getContentPane().add(textOcteto2);
		tela.getContentPane().add(labelPonto2);
		tela.getContentPane().add(textOcteto3);
		tela.getContentPane().add(labelPonto3);
		tela.getContentPane().add(textOcteto4);
		tela.getContentPane().add(labelBarra);
		tela.getContentPane().add(textCidr);
		tela.getContentPane().add(buttonIpInfo);
		tela.getContentPane().add(buttonLimpar);
		tela.getContentPane().add(labelMensagemErro);
		tela.getContentPane().add(labelIp);
		tela.getContentPane().add(labelCidr);
		tela.getContentPane().add(labelClasse);
		tela.getContentPane().add(labelMascaraDecimal);
		tela.getContentPane().add(labelMascaraBinaria);
		tela.getContentPane().add(labelIpsDisponiveis);
		tela.getContentPane().add(labelSubRedes);
		tela.getContentPane().add(scrollSubRedes);

		// Desativa as labels de resultado pois não há informações para serem exibidas
		ocultarLabels();

		buttonIpInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Caso tenha alguma label de resultado ativa, é desativada para evitar
				// possíveis erros caso o usuário insira novas informações que estejam erradas
				ocultarLabels();

				// Criação da classe responsável por validar os dados inseridos pelo usuário
				ValidadorIp validador = new ValidadorIp();

				String[] stringOctetosIp = { textOcteto1.getText(), textOcteto2.getText(), textOcteto3.getText(),
						textOcteto4.getText(), textCidr.getText() };

				String stringCidr = textCidr.getText();

				// Verifica se os campos estão vazios antes de passar para as próximas
				// verificações de valores
				if (validador.verificarCampos(stringOctetosIp[0], stringOctetosIp[1], stringOctetosIp[2],
						stringOctetosIp[3], stringCidr)) {

					// Método que retornará verdadeiro ou falso dependendo se os valores
					// inseridos pelo usuário podem ser transformar em números
					if (validador.verificarExistenciaDeNumeros(stringOctetosIp[0], stringOctetosIp[1],
							stringOctetosIp[2], stringOctetosIp[3], stringCidr)) {

						// Método responsável por verificar se o cidr está entre 1 e 32
						if (validador.validarCidr()) {

							// Método responsável por verificar se todos os campos do IP estão entre os
							// valores 0 e 255
							if (validador.validarIp()) {

								Ip ipInfo = new Ip();
								ipInfo.setIp(stringOctetosIp[0] + "." + stringOctetosIp[1] + "." + stringOctetosIp[2]
										+ "." + stringOctetosIp[3]);
								ipInfo.setCidr(Integer.valueOf(stringCidr));
								ipInfo.calcularClasse();
								ipInfo.calcularMascaraDecimal();
								ipInfo.calcularMascaraBinaria();
								ipInfo.calcularTotalIps();
								ipInfo.calcularSubRedes();

								labelIp.setText("IP: " + ipInfo.getIp());
								labelCidr.setText("CIDR: " + ipInfo.getCidr());
								labelClasse.setText("Classe do IP: " + ipInfo.getClasse());
								labelMascaraDecimal.setText("Máscara decimal: " + ipInfo.getMascaraDecimal());
								labelMascaraBinaria.setText("Máscara binária: " + ipInfo.getMascaraBinaria());
								labelIpsDisponiveis.setText("Total de IPs disponíveis: " + ipInfo.getQuantidadeIps());
								labelSubRedes.setText("Sub-redes: " + ipInfo.getSubRedes());

								modeloLista.clear();

								for (String subrede : ipInfo.getListaSubRedes()) {
									modeloLista.addElement(subrede);
								}

								labelMensagemErro.setVisible(false);
								mostrarLabels();

							} else {
								labelMensagemErro.setText("Os octetos precisam ter números de 0 a 255!");
								labelMensagemErro.setVisible(true);
							}

						} else {
							labelMensagemErro.setText("O CIDR precisa ir de 1 até 30!");
							labelMensagemErro.setVisible(true);
						}

					} else {
						labelMensagemErro.setText("Os campos só podem ter números!");
						labelMensagemErro.setVisible(true);
					}

				} else {
					labelMensagemErro.setText("Não pode ter campos vazios!");
					labelMensagemErro.setVisible(true);
				}

			}
		});

		buttonLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Limpa os campos e tira a mensagem de erro
				textOcteto1.setText(null);
				textOcteto2.setText(null);
				textOcteto3.setText(null);
				textOcteto4.setText(null);
				textCidr.setText(null);
				labelMensagemErro.setText(null);

				ocultarLabels();

			}
		});

		tela.setVisible(true);

	}

	private void mostrarLabels() {
		labelIp.setVisible(true);
		labelCidr.setVisible(true);
		labelClasse.setVisible(true);
		labelMascaraDecimal.setVisible(true);
		labelMascaraBinaria.setVisible(true);
		labelIpsDisponiveis.setVisible(true);
		labelSubRedes.setVisible(true);
		listaSubredes.setVisible(true);
		scrollSubRedes.setVisible(true);
	}

	private void ocultarLabels() {
		labelIp.setVisible(false);
		labelCidr.setVisible(false);
		labelClasse.setVisible(false);
		labelMascaraDecimal.setVisible(false);
		labelMascaraBinaria.setVisible(false);
		labelIpsDisponiveis.setVisible(false);
		labelSubRedes.setVisible(false);
		listaSubredes.setVisible(false);
		scrollSubRedes.setVisible(false);
	}

}
