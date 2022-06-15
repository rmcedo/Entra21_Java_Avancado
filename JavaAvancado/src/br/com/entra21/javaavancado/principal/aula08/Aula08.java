package br.com.entra21.javaavancado.principal.aula08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import br.com.entra21.javaavancado.Pessoa;
import br.com.entra21.javaavancado.principal.Aula;

public class Aula08 extends Aula {

	public Aula08(String titulo, ArrayList<String> assuntos) {
		super(titulo, assuntos);

	}

	@Override
	public byte capturarOpcao() {

		byte opcao = super.capturarOpcao();

		switch (opcao) {
		case 1:
			aprenderListar();
			break;
		case 2:
			aprenderFiltrar();
			break;

		case 3:
			aprenderEstatisticas();
			break;
		case 4:
			aprenderOrdenar();
			break;

		}
		return opcao;
	}

	private void aprenderListar() {

		ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(1, 5, 10, 8, 9, 15, 8, 3, 4, 2));
		ArrayList<String> nomes = new ArrayList<>(Arrays.asList("Rafael", "Macedo", "Fulano", "Beltrano"));

		System.out.println("Listando de forma muito resumida ");
		System.out.println("\n##############| LISTANDO DE FORMA RESUMIDA |##############\n");
		numeros.forEach(System.out::println);

		System.out.println("\n##############| LISTANDO DE FORMA NORMAL |##############\n");

		for (Integer numero : numeros) {
			System.out.println(numero);
		}

		System.out.println("\n##############| LISTANDO NOMES DE FORMA RESUMIDA |##############\n");
		nomes.forEach(System.out::println);

		System.out.println("\n##############| LISTANDO NOMES DE FORMA NORMAL |##############\n");

		for (String nome : nomes) {
			System.out.println(nome);

		}
		System.out.println("\n##############| LISTANDO UTILIZANDO ARROW -> |##############\n");

		System.out.println("--- Quando executa apenas uma instrucao nao precisa de escopo ---");
		nomes.forEach(nome -> System.out.println(nome));

		System.out.println("\n##############| LISTANDO UTILIZANDO ARROW -> |##############\n");
		System.out.println("--- Quando executa mais de uma instrucao é necessario declarar o escopo --- \n");
		nomes.forEach(nome -> {
			System.out.println(nome);
			System.out.println("[ " + nome + " ]");
		});
	}

	private void aprenderFiltrar() {

		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Rafael", (byte) 27));
		pessoas.add(new Pessoa("Juninho", (byte) 15));
		pessoas.add(new Pessoa("Joao", (byte) 18));
		pessoas.add(new Pessoa("Pedrinho", (byte) 28));

		pessoas.forEach(pessoa -> {
			System.out.println("nome: " + pessoa.getNome() + "\t | \tidade: " + pessoa.getIdade());
		});

		System.out.println(
				"\n##############| PERCORRENDO A LISTA E FILTRANDO APENAS OS MENORES DE IDADE |##############\n");
		List<Pessoa> pessoasNovas = pessoas.stream()// gera um stream para a minha lista, uma cópia que não afeta a
													// lista original
				.filter(pessoa -> pessoa.getIdade() < 18)// o filter vai filtrar com base no meu critério, criando uma
															// variável temporária que é verificada a cada item
				.collect(Collectors.toList());// os itens resultantes serão convertidos em uma lista

		pessoasNovas.forEach(pessoa -> {
			System.out.println("Essa pessoa é de menor? ");
			System.out.println("nome: " + pessoa.getNome() + "\t | \tidade: " + pessoa.getIdade());
		});
		System.out.println(
				"\n##############| PERCORRENDO A LISTA E FILTRANDO APENAS OS MENORES DE IDADE (SEM LAMBDA) |##############\n");
		ArrayList<Pessoa> pessoasMenores = new ArrayList<>();

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getIdade() < 18) {
				pessoasMenores.add(pessoa);

			}

		}
		for (Pessoa pessoa : pessoasMenores) {
			System.out.println("Essa pessoa é de menor? ");
			System.out.println("nome: " + pessoa.getNome() + "\t | \tidade: " + pessoa.getIdade());

		}

		System.out.println(
				"\n##############| FILTRANDO NOMES QUE TERMINAM COM A LETRA 'O' OU TEM MAIS DE 20 ANOS |##############\n");

		pessoas.stream().filter(pessoa -> pessoa.getNome().endsWith("o") || pessoa.getIdade() >= 18).forEach(pessoa -> {
			System.out.println("Essa pessoa termina com O: ");
			System.out.println("nome: " + pessoa.getNome() + "\t | \tidade: " + pessoa.getIdade());
		});

	}

	private void aprenderEstatisticas() {

		ArrayList<Double> notas = new ArrayList<>(Arrays.asList(10d, 8d, 7.5d));
		notas.forEach(System.out::println);
		DoubleSummaryStatistics estatisticas = notas.stream().mapToDouble((numero) -> numero).summaryStatistics();

		System.out.println("\nA média é: " + estatisticas.getAverage()); // PEGUEI A LISTA DE NUMEROS E COM O GETAVERAGE
																			// CONSIGO A MÉDIA

		System.out.println("\nA menor nota foi: " + estatisticas.getMin()); // PEGUEI A LISTA DE NUMEROS E COM O GETMIN
																			// PEGO O MENOR NUMERO DA LISTA

		System.out.println("\nA maior nota foi: " + estatisticas.getMax()); // PEGUEI A LISTA DE NUMEROS E COM O GETMAX
																			// PEGO O MAIOR NUMERO DA LISTA

		System.out.println("\nA maior nota foi: " + estatisticas.getSum()); // PEGUEI A LISTA DE NUMEROS E COM O GETSUM
																			// REALIZO A SOMA DAS NOTAS

		System.out.println("\nA quantidade de notas foi: " + estatisticas.getCount() + "\n"); // PEGUEI A LISTA DE
																								// NUMEROS E COM O
																								// GETCOUNT FAÇO A
																								// CONTAGEM DE ITENS

	}

	private void aprenderOrdenar() {

		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Rafael");
		nomes.add("Daiane");
		nomes.add("Vitor");
		nomes.add("Paula");
		nomes.add("Marcia");
		nomes.add("Mariano");
		nomes.add("Ananias");
		System.out.println("\n##############| LISTANDO OS NOMES NA ORDEM DE CRIAÇÃO |##############\n");
		nomes.forEach(System.out::println);

		System.out.println("\n##############| LISTANDO OS NOMES EM ORDEM ALFABÉTICA |##############\n");
		nomes.sort(String::compareTo); // COMPARETO ordena a lista
		nomes.forEach(System.out::println);

		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Rafael", (byte) 27));
		pessoas.add(new Pessoa("Juninho", (byte) 15));
		pessoas.add(new Pessoa("Joao", (byte) 18));
		pessoas.add(new Pessoa("Pedrinho", (byte) 28));
		Collections.sort(pessoas, new Comparator<Pessoa>() {
			@Override
			public int compare(Pessoa pessoaA, Pessoa pessoaB) {
				return pessoaA.getNome().compareTo(pessoaB.getNome());
			}
		});
		pessoas.forEach(pessoa->{
			System.out.println("\n##############| LISTANDO PESSOAS EM ORDEM ALFABÉTICA CRESCENTE |##############\n"); 
			//Para colocar em Ordem Decrescente, muda no return pessoaB compareTo pessoaA
			System.out.println(pessoa.getNome());
		});
		
		
		
	}

}
