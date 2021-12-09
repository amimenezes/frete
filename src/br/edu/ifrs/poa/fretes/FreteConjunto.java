/**
 * 
 */
package br.edu.ifrs.poa.fretes;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

/**
 * @author Chele
 *
 */
public class FreteConjunto<E> implements OperacoesConjunto<E>, Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	// implementa conjuntos ordenados
	private TreeSet<E> conjunto = new TreeSet<E>();

	public FreteConjunto() {
		this.conjunto = new TreeSet<E>();
	}

	@Override
	public boolean vazio() {
		return conjunto.isEmpty();
	}

	@Override
	public int tamanho() {
		return conjunto.size();
	}

	@Override
	public boolean cadastrar(E objeto) {
		return conjunto.add(objeto);
	}

	@Override
	public String listarTodos() {
		String aux = "";
		if (conjunto != null) {
			for (E elemento : conjunto) {
				if (elemento != null)
					aux += elemento.toString() + "\n";
			}
		}
		return aux;
	}

	@Override
	public boolean pesquisar(E objeto) {
		try {
			return conjunto.contains(objeto);
		} catch (NoSuchElementException e) {
			System.out.println("Lista vazia - não pode pesquisar!");
		}
		return false;
	}

	@Override
	public boolean excluir(E objeto) {
		try {
			return conjunto.remove(objeto);
		} catch (NoSuchElementException e) {
			System.out.println("Lista vazia - não pode remover!");
		}
		return false;
	}

	public Iterator<E> iterator() {
		return conjunto.iterator();
	}
}