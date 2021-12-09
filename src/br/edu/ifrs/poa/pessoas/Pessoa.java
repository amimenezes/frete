/**
 * 
 */
package br.edu.ifrs.poa.pessoas;

import java.io.Serializable;

/**
 * @author Chele
 *
 */
public abstract class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	
	/**
	 * 
	 */
	public Pessoa() {
	}

	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa [" + (nome != null ? "nome=" + nome : "") + "]";
	}
	
	

}
