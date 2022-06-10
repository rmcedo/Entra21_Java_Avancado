package br.com.entra21.javaavancado.principal.aula06;

import java.util.HashMap;

public interface ICrud<A> {

	public void listar(HashMap<String, A> lista);

	public void adicionar();
	
	public A capturarValores();
	
	public A buscar(A chave);
	
	public A capturarChave();
	
	public void editar(A chave);
	
	public void deletar(A chave);
	
	

}
