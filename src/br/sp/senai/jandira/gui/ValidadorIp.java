package br.sp.senai.jandira.gui;

public class ValidadorIp {

	private int[] OctetosIp = { 0, 0, 0, 0 };
	private int cidr;

	public boolean verificarCampos(String primeiroOcteto, String segundoOcteto, String terceiroOcteto,
			String quartoOcteto, String stringCidr) {

		if (primeiroOcteto.isEmpty() || segundoOcteto.isEmpty() || terceiroOcteto.isEmpty() || quartoOcteto.isEmpty()
				|| stringCidr.isEmpty()) {
			return false;
		}

		return true;
	}

	public boolean verificarExistenciaDeNumeros(String primeiroOcteto, String segundoOcteto, String terceiroOcteto,
			String quartoOcteto, String stringCidr) {

		try {
			OctetosIp[0] = Integer.parseInt(primeiroOcteto);
			OctetosIp[1] = Integer.parseInt(segundoOcteto);
			OctetosIp[2] = Integer.parseInt(terceiroOcteto);
			OctetosIp[3] = Integer.parseInt(quartoOcteto);
			cidr = Integer.parseInt(stringCidr);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean validarCidr() {

		try {
			return (cidr >= 1 && cidr <= 30);

		} catch (Exception e) {
			return false;
		}

	}

	public boolean validarIp() {

		for (int i : OctetosIp) {
			if (i < 0 || i > 255) {
				return false;
			}
		}

		return true;

	}

}
