/**
 * 
 */
package br.edu.ifrs.poa.fretes;

import java.io.Serializable;

import br.edu.ifrs.poa.util.Validador;

/**
 * @author Chele
 *
 */
public class ItemFrete implements Validador, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Atributos*/
	private String descricao;
	private double peso;
	
	/*Construtor vazio*/
	public ItemFrete() {
	}
	
	/*Construtor com parâmetros*/
	public ItemFrete(String descricao, double peso) {
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "ItemFrete [" + (descricao != null ? "descricao=" + descricao + ", " : "") + "peso=" + peso + "]";
	}
	
}
