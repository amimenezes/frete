/**
 * Fazer somente uma COLEÇÃO PARA GUARDAR OS FRETES
 */
package br.edu.ifrs.poa.menu;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

import br.edu.ifrs.poa.fretes.FreteConjunto;
import br.edu.ifrs.poa.arquivos.ManipularArquivos;
import br.edu.ifrs.poa.fretes.Frete;
import br.edu.ifrs.poa.fretes.ItemFrete;
import br.edu.ifrs.poa.menu.EnumMenu.EnumOption;
import br.edu.ifrs.poa.pessoas.Cliente;
import br.edu.ifrs.poa.util.EnumSituacao;

/**
 * @author Chele
 *
 */

public class Menu {

	public static void main(String[] args) {
		String arqLeitura = "ArquivoObjetos.bin";
		// Inicio da Validação das opções do Menu
		try {
			FreteConjunto<Frete> conjListaFrete = ManipularArquivos.lerArquivoBinario(arqLeitura);
			if (conjListaFrete == null) {
				conjListaFrete = new FreteConjunto<Frete>();
			}
			while (true) {
				switch (montaMenu()) {
				case 1:// Cadastrar Frete
					Cliente cliente = new Cliente();
					Frete frete = new Frete();

//					boolean aux = false;
//					while (aux == false) {
//						String nomeCliente = JOptionPane.showInputDialog("Informe o nome do Cliente:");
//						if (nomeCliente.trim().isEmpty()) {
//							JOptionPane.showMessageDialog(null,
//									"Você não digitou nenhuma informação.\nDigite algo para cadastrar.");
//							aux = false;
//						} else {
//							cliente.setNome(nomeCliente);
//							aux = true;
//						}
//					}

					boolean aux = false;
					while (aux == false) {
						String nomeCliente = JOptionPane.showInputDialog("Informe o nome do Cliente:");
						if (ValidarMenu.validaString(nomeCliente)) {
							cliente.setNome(nomeCliente);
							aux = true;
						} else {
							aux = false;
						}
					}

					aux = false;
					while (aux == false) {
						String enderecoCliente = JOptionPane.showInputDialog("Informe o endereco do Cliente:");
						if (ValidarMenu.validaString(enderecoCliente)) {
							cliente.setEndereco(enderecoCliente);
							aux = true;
						} else {
							aux = false;
						}
					}

					aux = false;
					while (aux == false) {
						String telefoneCliente = JOptionPane.showInputDialog("Informe o telefone do Cliente:");
						if (ValidarMenu.validaString(telefoneCliente)) {
							cliente.setTelefone(telefoneCliente);
							aux = true;
						} else {
							aux = false;
						}
					}

					boolean auxCpf = false;
					while (auxCpf == false) {
						String cpfCliente = JOptionPane.showInputDialog("Informe o cpf do Cliente:");
						auxCpf = cliente.validarCPF(cpfCliente);
						if (ValidarMenu.validaString(cpfCliente)) {
							cliente.setCpf(cpfCliente);
							auxCpf = true;
						} else if(!auxCpf) {
							JOptionPane.showMessageDialog(null, "CPF inválido!");
							auxCpf = false;
						}
					}

					// Cadastrar atributos do Frete
					aux = false;
					while (aux == false) {
						try {
							double valorFrete = Double
									.parseDouble(JOptionPane.showInputDialog("Informe o valor do Frete:"));
							frete.setValor(valorFrete);
							aux = true;
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null,
									"Você digitou um valor inválido.\nDigite numeral para cadastrar.");
							aux = false;
						}
					}

					aux = false;
					while (aux == false) {
						String origemFrete = JOptionPane.showInputDialog("Informe a Origem do Frete:");						
						if (ValidarMenu.validaString(origemFrete)) {
							frete.setCidadeOrigem(origemFrete);
							aux = true;
						} else {
							aux = false;
						}
					}

					aux = false;
					while (aux == false) {
						String destinoFrete = JOptionPane.showInputDialog("Informe o Destino do Frete:");
						if (ValidarMenu.validaString(destinoFrete)) {
							frete.setCidadeDestino(destinoFrete);
							aux = true;
						} else {
							aux = false;
						}						
					}

					// Pega a Situacao do Frete
					String str = "";
					aux = false;
					// Cria o submenu das opções de Situação
					for (EnumSituacao op : EnumSituacao.values()) {
						str += op.toString() + "\n";
					}
					while (aux == false) {
						try {
							int numSituacaoFrete = Integer
									.parseInt(JOptionPane.showInputDialog("Informe a Situação:\n" + str));
							if ((numSituacaoFrete != EnumSituacao.EM_ANDAMENTO.getId())
									&& (numSituacaoFrete != EnumSituacao.CANCELADO.getId())
									&& (numSituacaoFrete != EnumSituacao.ENCERRADO.getId())) {
								JOptionPane.showMessageDialog(null,
										"Você digitou um valor inválido.\nDigite 1, 2 ou 3 para cadastrar.");
								aux = false;
							} else {
								frete.setSituacaoFrete(numSituacaoFrete);
								aux = true;
							}
							aux = true;
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null,
									"Você digitou um valor inválido.\nDigite numeral para cadastrar.");
							aux = false;
						}
					}

					// Pega a lista de itens do frete
					ArrayList<ItemFrete> listaItemFrete = new ArrayList<ItemFrete>();

					// Pega os atributos de cada item do Frete
					ItemFrete itemFrete = new ItemFrete();
					aux = false;
					while (aux == false) {
						String descricao = JOptionPane.showInputDialog("Informe a descrição do Frete:");
						if (ValidarMenu.validaString(descricao)) {
							itemFrete.setDescricao(descricao);
							aux = true;
						} else {
							aux = false;
						}						
					}

					// Validando o atributo Peso
					aux = false;
					while (aux == false) {
						try {
							String inputPeso = JOptionPane.showInputDialog("Informe o peso do Frete:");
							/*if (inputPeso.trim().isEmpty()) {*/
							if (!ValidarMenu.validaString(inputPeso)) {								
								aux = false;
							} else if (!itemFrete.validaPeso(Double.parseDouble(inputPeso))) {
								aux = false;
							} else {
								itemFrete.setPeso(Double.parseDouble(inputPeso));
								aux = true;
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null,
									"Você digitou um valor inválido.\nDigite numeral para cadastrar.");
							aux = false;
						}
					}

					// Adicionando o item frete na listas de itens frete
					listaItemFrete.add(itemFrete);
					frete.setListaItensFrete(listaItemFrete);

					// Adiciona o objeto cliente no frete
					// (todos os atributos de Cliente inseridos nos inputs)
					frete.setCliente(cliente);

					// Adiciona todos os atributos de Frete inseridos nos inputs
					conjListaFrete.cadastrar(frete);
					break;

				case 2:// Listar Todos os Fretes
					if (conjListaFrete.vazio()) {
						JOptionPane.showMessageDialog(null,
								"-- Conjunto de Fretes --\r\n" + "O Conjunto de Fretes está vazia.\r\n");
					} else {
						JOptionPane.showMessageDialog(null,
								"-- Conjunto de Fretes --\r\n" + conjListaFrete.listarTodos() + "\r\n");
					}
					break;

				case 3:// Listar todos os fretes que um cliente solicitou
						// (pesquisar pelo nome do cliente)
					String nomePesquisa = JOptionPane.showInputDialog("Informe o nome do cliente a ser pesquisado:");

					FreteConjunto<Frete> conjAuxFrete = new FreteConjunto<Frete>();
					boolean flag = false;
					int totalCliente = 0;
					Iterator<Frete> it = conjListaFrete.iterator();

					while (it.hasNext()) {
						Frete obj = it.next();
						if (obj.getCliente().getNome().equalsIgnoreCase(nomePesquisa)) {
							flag = true;
							conjAuxFrete.pesquisar(obj);
							totalCliente++;
						}
					}
					if (flag == false) {
						JOptionPane.showMessageDialog(null,
								"O Cliente informado: " + nomePesquisa + " não tem Fretes cadastrados.");
					} else {
						JOptionPane.showMessageDialog(null, "-- Conjunto de Fretes --\r\n" + conjAuxFrete.listarTodos()
								+ "O Cliente: " + nomePesquisa + " tem um Total de Fretes: " + totalCliente + "\r\n");
					}
					break;
				case 4:// Remover frete usando a situação
					int numSit = Integer
							.parseInt(JOptionPane.showInputDialog("Informe o número da situação a ser removida:"));
					conjAuxFrete = new FreteConjunto<Frete>();
					flag = false;
					totalCliente = 0;
					it = conjListaFrete.iterator();

					while (it.hasNext()) {
						Frete obj = it.next();
						if (obj.getSituacaoFrete() == numSit) {
							flag = true;
							conjListaFrete.excluir(obj);

							if (conjListaFrete.vazio()) {
								totalCliente = 0;
							} else {
								totalCliente--;
							}
						}
					}
					if (flag == false) {
						JOptionPane.showMessageDialog(null, "Não tem Fretes cadastrados com a Situação informada.");
					} else {
						JOptionPane.showMessageDialog(null,
								"-- Conjunto de Fretes --\r\n" + conjListaFrete.listarTodos() + "A situação: " + numSit
										+ " foi removida e agora tem um Total de Fretes: " + totalCliente + "\r\n");
					}

					break;
				case 5:
					// Adiciona o conjunto de Fretes no arquivo: "ArquivoObjetos.bin"
					ManipularArquivos.gravarArquivoBinario(conjListaFrete, arqLeitura);
					// Sai do programa
					System.exit(0);
					break;
				}
			}
		}
		// Fim da Validação das opções do Menu
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite uma opção válida!\n Opções: 1, 2, 3, 4 ou 5.");
		}
	}

	// Métodos específicos
	private static int montaMenu() {
		String str = "";
		for (EnumOption op : EnumOption.values())
			str += op.toString() + "\n";
		return Integer.parseInt(JOptionPane.showInputDialog(str));
	}
}