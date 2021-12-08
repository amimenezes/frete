/**
 * 
 */
package br.edu.ifrs.poa.util;

import java.io.Serializable;

/**
 * @author Chele
 *
 */
public enum EnumSituacao implements Serializable {

	//Enum
	EM_ANDAMENTO(1, "Em Andamento"),
	CANCELADO(2, "Cancelado"),
	ENCERRADO(3, "Encerrado");
	
	/*Variáveis*/
	private final String nome;
	private final int id;
	
	//Constructor
	EnumSituacao(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.getId() + " - " + this.getNome();
	}
}
