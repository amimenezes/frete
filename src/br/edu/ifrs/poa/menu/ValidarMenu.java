package br.edu.ifrs.poa.menu;

import javax.swing.JOptionPane;

// Validei, por enquanto, s� o tipo String
public class ValidarMenu {
	public static boolean validaString(String stringValor) {
		if (stringValor.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Voc� n�o digitou nenhuma informa��o.\nDigite algo para cadastrar.");
			return false;
		}
		return true;
	}
}