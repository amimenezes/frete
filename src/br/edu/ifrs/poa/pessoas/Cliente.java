/**
 * 
 */
package br.edu.ifrs.poa.pessoas;

import java.io.Serializable;

/**
 * @author Chele
 *
 */
public class Cliente extends Pessoa implements ValidarCpf, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Atributos*/
	private String endereco;
	private String telefone;
	private String cpf;

	/*Construtor vazio*/
	public Cliente() {
	}

	/*Construtor com parâmetros*/
	public Cliente(String nome, String endereco, String telefone, String cpf) {
		super(nome);
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {		
		return "Cliente [" + super.toString() + (endereco != null ? "endereco=" + endereco + ", " : "")
				+ (telefone != null ? "telefone=" + telefone + ", " : "") + (cpf != null ? "cpf=" + cpf : "") + "]";
	}

}