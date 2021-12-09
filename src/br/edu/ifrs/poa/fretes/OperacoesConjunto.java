/**
 * 5) Defina a classe gen�rica que implementa a interface OperacoesConjunto.
 * Definido os m�todos declarados na interface
 * (use conjunto ordenado, que ordena o frete pelo seu valor)
*/
package br.edu.ifrs.poa.fretes;

/**
 * @author Chele
 *
 */
/*Porque em interface n�o se pode implementar Serializable ?*/
public interface OperacoesConjunto<E> {

	public boolean vazio();

	public int tamanho();

	public boolean cadastrar(E objeto);

	public String listarTodos();

	public boolean pesquisar(E objeto);

	public boolean excluir(E objeto);

}