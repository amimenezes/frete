/**
 * 
 */
package br.edu.ifrs.poa.arquivos;

/**
 * @author Chele
 *
 */
import java.io.IOException;

import br.edu.ifrs.poa.fretes.Frete;
import br.edu.ifrs.poa.fretes.FreteConjunto;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class ManipularArquivos {

	// Serialização: Grava o Objeto no Arquivo Binário "nomeArq"
	public static void gravarArquivoBinario(FreteConjunto<Frete> lista, String nomeArq) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(nomeArq)));) {
			// Escrevendo Objeto no Arquivo
			out.writeObject(lista);
			System.out.println("Salvando objeto no arquivo!\n");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e);
		} catch (StreamCorruptedException e) {
			System.out.println("Objeto corrompido: " + e);
		} catch (IOException e) {
			System.out.println("Ocorreu uma exceção: " + e);
		} catch (Exception e) {
			System.out.println("Ocorreu uma exceção na leitura: " + e);
		}
	}

	// desserialização: recuperando os objetos gravados no arquivo binário "nomeArq"
	public static FreteConjunto<Frete> lerArquivoBinario(String arquivoLeitura) {
		// Abre o Arquivo e Desserializa
		try (FileInputStream arqStream = new FileInputStream(arquivoLeitura);
				ObjectInputStream input = new ObjectInputStream(arqStream);) {
			// Lendo Objeto no Arquivo
			@SuppressWarnings("unchecked")
			FreteConjunto<Frete> objPessoa = (FreteConjunto<Frete>) input.readObject();
			System.out.println("Objeto lido do arquivo:\n" + objPessoa);
			System.out.println(objPessoa.tamanho());
			return objPessoa;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrado: " + e);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e);
		} catch (StreamCorruptedException e) {
			System.out.println("Objeto corrompido: " + e);
		} catch (EOFException e) {
			System.out.println("Ocorreu uma exceção: " + e + ": fim do arquivo atingido!");
			return null;
		} catch (IOException e) {
			System.out.println("Ocorreu uma exceção: " + e);
		} catch (Exception e) {
			System.out.println("Ocorreu uma exceção na leitura: " + e);
		}
		return null;
	}
}