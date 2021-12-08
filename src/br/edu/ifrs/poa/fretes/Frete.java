/**
 * 
 */
package br.edu.ifrs.poa.fretes;

import java.io.Serializable;
import java.util.ArrayList;
import br.edu.ifrs.poa.pessoas.Cliente;

/**
 * @author Chele
 *
 */
public class Frete implements Comparable<Frete>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Atributos*/
	private double valor;
	private String cidadeOrigem;
	private String cidadeDestino;
	//Cliente
	Cliente cliente = new Cliente();
	private int situacaoFrete;
	ArrayList<ItemFrete> listaItensFrete = new ArrayList<ItemFrete>();
	
	/*Construtor vazio*/
	public Frete() {
	}

	/*Construtor com parâmetros*/
	public Frete(
			double valor, String cidadeOrigem, String cidadeDestino,
			Cliente cliente,
			int situacaoFrete, ArrayList<ItemFrete> listaItensFrete) {
		this.valor = valor;
		this.cidadeOrigem = cidadeOrigem;
		this.cidadeDestino = cidadeDestino;
		this.cliente = cliente;
		this.situacaoFrete = situacaoFrete; 
		this.listaItensFrete = listaItensFrete;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the cidadeOrigem
	 */
	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	/**
	 * @param cidadeOrigem the cidadeOrigem to set
	 */
	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	/**
	 * @return the cidadeDestino
	 */
	public String getCidadeDestino() {
		return cidadeDestino;
	}

	/**
	 * @param cidadeDestino the cidadeDestino to set
	 */
	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}
	
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * @return the situacaoFrete
	 */
	public int getSituacaoFrete() {
		return situacaoFrete;
	}
	/**
	 * @param situacaoFrete the situacaoFrete to set
	 */
	public void setSituacaoFrete(int situacaoFrete) {
		this.situacaoFrete = situacaoFrete;
	}	
	/**
	 * @return the listaItensFrete
	 */
	public ArrayList<ItemFrete> getListaItensFrete() {
		return listaItensFrete;
	}

	/**
	 * @param listaItensFrete the listaItensFrete to set
	 */
	public void setListaItensFrete(ArrayList<ItemFrete> listaItensFrete) {
		this.listaItensFrete = listaItensFrete;
	}

	@Override
	public String toString() {
		String auxListaItensFrete = "";
		if (listaItensFrete != null) {
			for (ItemFrete itemF : listaItensFrete) {
				if (itemF != null) {
					// concatena um item do frete embaixo um do outro
					auxListaItensFrete += itemF.toString() + "\n";
				}
			}
		}
		return "Frete [\n valor=" + valor + ", " + (cidadeOrigem != null ? "cidadeOrigem=" + cidadeOrigem + ", " : "Cidade Origem Inválida.")
				+ (cidadeDestino != null ? "cidadeDestino=" + cidadeDestino : "Cidade Destino Inválida.")
				+ ", \n cliente=" + cliente
				+ " situacaoFrete=" + situacaoFrete
				+ ", \n listaItensFrete=" + auxListaItensFrete + "]";
	}
	
	@Override
	public int compareTo(Frete o1) {

		// só para string
		//return valor.compareTo(o1.getValor());
		
		if(valor > o1.getValor()) return 1;
		if(valor < o1.getValor()) return -1;
		return 0;
	}
}