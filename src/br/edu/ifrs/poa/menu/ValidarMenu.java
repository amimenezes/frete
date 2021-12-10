package br.edu.ifrs.poa.menu;

import javax.swing.JOptionPane;

// Validei, por enquanto, só o tipo String
public class ValidarMenu {
	public static boolean validaString(String stringValor) {
		if (stringValor.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Você não digitou nenhuma informação.\nDigite algo para cadastrar.");
			return false;
		}
		return true;
	}
}