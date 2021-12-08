/**
 * 
 */
package br.edu.ifrs.poa.util;

import javax.swing.JOptionPane;

/**
 * @author Chele
 *
 */
public interface Validador {

	/*Métodos*/
	public default boolean validaPeso(double peso) {
		
		if((peso >= 1) && (peso <= 30)) {
			//JOptionPane.showMessageDialog(null, "RN01 - Peso inválido.\nValor aceito: 1 a 30kg.");
			//System.out.println("Peso valido! Entre 1 e 30kg.");
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "RN01 - Peso inválido.\nValor aceito: 1 a 30kg.");
			//System.out.println("Peso inválido. Somente aceita entre 1 a 30kg");
			return false;
		}
	}

}