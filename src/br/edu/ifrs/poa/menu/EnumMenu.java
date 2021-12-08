package br.edu.ifrs.poa.menu;

import java.io.Serializable;

/**
 * @author Chele
 *
 */
public class EnumMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	enum EnumOption {

		CADASTRAR_FRETE(1, "Cadastrar Frete\r\n"),
		LISTAR_TODOS_FRETES(2, "Listar todos os fretes\r\n"),
		LISTAR_TODOS_FRETES_NOME_CLIENTE(3, "Listar todos os fretes que um cliente solicitou\n"
				+ "(pesquisar pelo nome do cliente)\r\n"),
		REMOVER_FRETE_SITUACAO(4, "Remover frete usando a situação\r\n"),
		FECHAR(5, "Sair");

		// instance variable
		private final int id;
		private final String nomeOpcao;

		// constructor
		EnumOption(int iOpcao, String nomeOpcao) {
			this.id = iOpcao;
			this.nomeOpcao = nomeOpcao;
		}

		// instance methods
		public int getItem() {
			return id;
		}

		public String getString() {
			return nomeOpcao;
		}

		@Override
		public String toString() {
			return this.getItem() + " - " + this.getString();
			
		}
	}
}
