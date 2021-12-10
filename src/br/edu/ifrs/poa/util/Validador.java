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

	/*M�todos*/
	public default boolean validaPeso(double peso) {
		
		if((peso >= 1) && (peso <= 30)) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "RN01 - Peso inv�lido.\nValor aceito: 1 a 30kg.");
			return false;
		}
	}

}