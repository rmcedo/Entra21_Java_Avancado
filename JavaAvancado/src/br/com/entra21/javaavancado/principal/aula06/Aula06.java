package br.com.entra21.javaavancado.principal.aula06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import br.com.entra21.javaavancado.Pessoa;
import br.com.entra21.javaavancado.Repositorio;
import br.com.entra21.javaavancado.principal.Aula;

public class Aula06 extends Aula implements ICrud<Pessoa> {

	public static HashMap<String, Pessoa> pessoas = new HashMap<>();

	public Aula06(String titulo, ArrayList<String> assuntos) {
		super(titulo, assuntos);

		if (pessoas.isEmpty()) {
			pessoas.put("Fulano", new Pessoa("Fulano", (byte) 33));
			pessoas.put("Teste", new Pessoa("Teste", (byte) 24));
			pessoas.put("Jos�", new Pessoa("Jos�", (byte) 17));
			pessoas.put("Maria", new Pessoa("Maria", (byte) 18));
		}

	}

	@Override
	public byte capturarOpcao() {

		byte opcao = super.capturarOpcao();
		switch (opcao) {
		case 1:
			aprenderGenerics();
			break;
		case 2:
			listar(Repositorio.pessoas);
		case 3:
			adicionar();
			break;
		case 4:
			editar(capturarChave()); 
			break;
		case 5:
			deletar(capturarChave());
			break;

		}
		return opcao;
	}

	private void aprenderGenerics() {
		System.out.println("Criar uma Interface onde o nome ter� um sufixo <Letra>");
		System.out.println("Essa letra � um par�metro para quem implementar essa interface.");
		System.out.println(
				"Os m�todos gerados que tinham essa Letra ser�o substituidos pelo par�metro informado pela classe");
	}


	@Override
	public void listar(HashMap<String, Pessoa> lista) {
		System.out.println("-----Listando Pessoas------");
		for (Entry<String, Pessoa> pessoa : lista.entrySet()) {
			System.out.println("Chave: " + pessoa.getKey() + " \t\t" + pessoa.getValue().getNome() + "\t"
					+ pessoa.getValue().getIdade());

		}
		System.out.println("->" + (lista.isEmpty() ? " Lista vazia" : " Quantidade " + lista.size()));
	}

	@Override
	public void adicionar() {
		Pessoa novo = capturarValores();
		if (buscar(novo) == null) {
			Repositorio.pessoas.put(novo.getNome(), novo);
		} else {
			System.out.println("Ja existe alguem com a chave " + novo.getNome());
		}

	}

	@Override
	public Pessoa capturarValores() {
		Pessoa formulario = new Pessoa();
		System.out.println("\nInforme o nome: ");
		formulario.setNome(super.getEntrada().next());
		System.out.println("\nInforme a idade: ");
		formulario.setIdade(super.getEntrada().nextByte());
		return formulario;
	}

	@Override
	public Pessoa buscar(Pessoa chave) {
		Pessoa busca = Repositorio.pessoas.get(chave.getNome());
		return busca;
	}

	@Override
	public Pessoa capturarChave() {

		Pessoa chave = new Pessoa();
		System.out.println("Informe o valor da chave ");
		chave.setNome(super.getEntrada().next());

		return chave;
	}

	@Override
	public void editar(Pessoa chave) {

		if (buscar(chave) != null) {
			Pessoa editado = capturarValores();
			Repositorio.pessoas.put(chave.getNome(), editado);
		} else {
			System.out.println("\nN�o existe algu�m com a chave: " + chave.getNome());

		}

	}

	@Override
	public void deletar(Pessoa chave) {
		if (buscar(chave) != null) {
			Repositorio.pessoas.remove(chave.getNome());
		} else {
			System.out.println("\nN�o existem ningu�m com a chave: " + chave.getNome());
		}

	}

}