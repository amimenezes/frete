package br.edu.ifrs.poa.menu;

import javax.swing.JOptionPane;

import br.edu.ifrs.poa.pessoas.Cliente;

public interface ValidarMenu {
	public default boolean validarNomeCliente(String nomeCliente) {
		Cliente cliente = new Cliente();
		boolean aux = false;
		while (aux == false) {			
			if (nomeCliente.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Você não digitou nenhuma informação.\nDigite algo para cadastrar.");
				aux = false;
			} else {
				cliente.setNome(nomeCliente);
				aux = true;
			}
		}
		return aux;
	}
}