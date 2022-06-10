package br.com.entra21.javaavancado;

import java.util.HashMap;

public class Repositorio {
	public static HashMap<String, Pessoa> pessoas = new HashMap<>();

	public static void inicializarPessoas() {

		if (pessoas.isEmpty()) {
			pessoas.put("Rafael", new Pessoa("Rafael", (byte) 28));
			pessoas.put("Daiane", new Pessoa("Daiane", (byte) 27));
		}
		;

	}

}
