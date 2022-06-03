package br.com.entra21.javaavancado.principal.aula02.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AprenderCollections {
	static Scanner input = new Scanner(System.in);

	public static void aprender() {

		byte option;

		do {
			System.out.println("\t\t\nJAVA AVANÇADO - COLLECTIONS");
			System.out.println("\n0 - Sair");
			System.out.println("\n1 - Aprender ArrayList");
			System.out.println("\n2 - Aprender LinkedList");
			option = input.nextByte();

			switch (option) {

			case 0:
				System.out.println("\nSAINDO...");
				break;

			case 1:
				aprenderArrayList();

				break;

			case 2:
				aprenderLinkedList();
				break;

			default:
				System.out.println("\nPor favor, selecione uma opção válida :)");
				break;
			}

		} while (option != 0);

		System.out.println("\n\nShow... acredito que já conhece o assunto!! Volte sempre para aprender mais :):)");

	}

	private static void aprenderArrayList() {

		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Rafael");
		nomes.add("Fulano");
		nomes.add("Beltrano");
		nomes.add(0, "Inserido"); // Mesmo esse sendo o ultimo adicionado, colocando o 0, coloco ele no topo da lista e organiza os outros.
		nomes.add("Rubem");
		
		System.out.println("Quantos nomes? " + nomes.size());
		
		for(String item:nomes) {
			System.out.println("O nome no momento é: "+item);
		}
		for (int nome = 0; nome < nomes.size(); nome++) {
			System.out.println("No indice "+nome+" tem o valor "+nomes.get(nome));
			
		}
		System.out.println("O primeiro nome é: "+nomes.get(0));
		System.out.println("\nO 2º nome é: "+nomes.get(1));
		
		nomes.set(1, "Rafael Atualizado");
		System.out.println("\nO nome é: "+nomes.get(1));
		//nomes.set(0, nomes.get(0).toUpperCase()); //Aproveitou o nome que tinha e colocou em CAIXA ALTA
		nomes.set(0, nomes.get(3).toUpperCase()); // Transformou o nome da posição 0 para o nome da pos. 3 e colocou em CAIXA ALTA
		System.out.println("\nO nome é: "+nomes.get(0));
		
		System.out.println("\n\nOnde será que está o Rubem? "+nomes.indexOf("Rubem"));
		
		nomes.remove(2); //removendo o item no indice 2
		nomes.remove(nomes.indexOf("Rubem"));//Como nao sei a posição, faço uma pesquisa.
		
		//CRIAR UMA LISTA DE INTERESSES
		//INCLUA 5 INTERESSES
		//LISTE TODOS OS INTERESSES
		//ESCOLHA 2 PARA MOSTRAR QUAIS SÃO SEUS FAVORITOS
		//EXCLUA 1 ITEM POR POSIÇÃO E OUTRO POR VALOR
		//SYSOUT EXPLICANDO CADA AÇÃO DESSA
		
		System.out.println("Criei uma lista com 5 generos de filmes:\n");
		
		ArrayList<String> interesses = new ArrayList<>();
		
		interesses.add("terror");
		interesses.add("ação");
		interesses.add("ficção cientifica");
		interesses.add("drama");
		interesses.add("comédia");
		
		System.out.println("Em seguida, irei listar todas os generos que escolhi:\n");
		
		for (String generos : interesses) {
			System.out.println("Os generos são: "+generos);
			}
		System.out.println("\nColocarei a lista em ordem de acordo com meu gosto: \n");
		interesses.set(0, "ficção cientifica");
		interesses.set(1, "ação");
		interesses.set(2, "drama");
		interesses.set(3, "comédia");
		interesses.set(4, "terror");
		
		System.out.println("Agora minha lista ficou assim, de acordo com meu gosto: \n");
		for (String generos : interesses) {
			System.out.println("Os generos são: "+generos);
			
		}
		System.out.println("Meus dois generos preferidos são: "+interesses.get(0)+" e "+interesses.get(1));
		
		System.out.println("\n\nEm seguida irei excluir dois generos: \n");
		interesses.remove(2);
		interesses.remove(interesses.indexOf("terror"));
		
		System.out.println("Para finalizar, minha lista ficou assim: \n");
		for (String generos : interesses) {
			System.out.println("Os generos são: "+generos);
			
			
		}
		
	}
		

	private static void aprenderLinkedList() {
		
		LinkedList<String> nomes = new LinkedList<>();


		System.out.println("---------------Inserindo itens no LINKED ------------------");
		nomes.add("Rubem");
		nomes.add("Fulano");
		nomes.addFirst("Teste");
		nomes.addLast("Ultimo");
		nomes.add(2, "Inserido");

		System.out.println("Quantos nomes? "+nomes.size());


		System.out.println("---------------Acessando itens no LINKED ------------------");
		System.out.println("Quem é o primeiro? " + nomes.getFirst());
		System.out.println("Quem é o segundo? " + nomes.get(1));
		System.out.println("Quem é o ultimo? " + nomes.getLast()); 
				
		 
		System.out.println("---------------Percorrendo itens no LINKED com iteração em array------------------");
		System.out.println("Ordem de inserção");
		for (String nome : nomes) {
			System.out.println("nome = " + nome);
		} 


		System.out.println("---------------Percorrendo itens no LINKED com index em array------------------");
		System.out.println("De forma inversa");
		for (int nome = nomes.size() - 1; nome >= 0; nome--) {

			System.out.println("(" + nome + ") cargo = " + nomes.get(nome));

		} 


		System.out.println("---------------Removendo itens no LINKED ------------------");
		System.out.println("Removendo quem estava no indice 0 ou seja "+nomes.getFirst());
		nomes.removeFirst();//removi o item no indice 0


		System.out.println("Removendo quem tem o nome \"Fulano\" pelo valor, sem saber que esta no indice "+nomes.indexOf("Fulano"));
		nomes.remove("Fulano");//remove o elemento que tiver esse valor, o indice será procurado

		System.out.println("---------------Percorrendo itens no LINKED com forEach------------------");
		nomes.forEach(nome -> {     System.out.println("nome " + nome);
		});


			

		
		
		
		

	}

}
