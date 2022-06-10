package br.com.entra21.javaavancado.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import br.com.entra21.javaavancado.Repositorio;
import br.com.entra21.javaavancado.principal.aula01.enums.PersonagemJogo;
import br.com.entra21.javaavancado.principal.aula02.collections.list.AprenderCollections;
import br.com.entra21.javaavancado.principal.aula03.Aula03;
import br.com.entra21.javaavancado.principal.aula04.Aula04;
import br.com.entra21.javaavancado.principal.aula05.Aula05;
import br.com.entra21.javaavancado.principal.aula06.Aula06;

public class Main {

	static Scanner input = new Scanner(System.in);

	public enum DiasSemana {
		SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO;

	}

	public static void main(String[] args) {
		byte option;
		Repositorio.inicializarPessoas();

		do {
			System.out.println(exibirMenu());
			option = input.nextByte();

			switch (option) {
			case 0:
				System.out.println("SAINDO...");

				break;

			case 1:
				aprenderWrapper();

				break;

			case 2:
				aprenderEnum();
				break;

			case 3:
				AprenderCollections.aprender();
				break;
			case 4:
				Aula03.aprender();
				break;
			case 5:
				String titulo = "Aula04 - Collections - SET - HashSet";

				ArrayList<String> assuntos = new ArrayList<>();
				assuntos.add("Definir");
				assuntos.add("CRUD");

				Aula04 aula04 = new Aula04(titulo, assuntos);
				aula04.aprender();
				break;
			case 6:
				new Aula05("Aula05 - Collections - MAP - HashMap",
						new ArrayList<>(
								Arrays.asList("Definir", "Create", "Read", "Update", "Delete", "Exemplo prático")))
						.aprender();
				break;
			case 7:
				new Aula06("Aula 06", new ArrayList<>(Arrays.asList("Aprender Generics", "Listar Pessoas",
						"Adicionar Pessoa", "Editar Pessoa", "Deletar Pessoa"))).aprender();
				break;

			default:
				System.out.println("\n\nPor favor, selecione uma opção válida");
				break;
			}

		} while (option != 0);

	}

	private static String exibirMenu() {

		String menu = "\n\t\tJAVA AVANÇADO!\n\n";
		menu += "\n\tESCOLHA UMA DAS OPÇÕES:";
		menu += "\n\t0 - SAIR";
		menu += "\n\t1 - WRAPPER";
		menu += "\n\t2 - ENUM";
		menu += "\n\t3 - COLLECTIONS -> LIST";
		menu += "\n\t4 - ANNOTATIONS E DATAS";
		menu += "\n\t5 - COLLECTIONS -> HASH-SET";
		menu += "\n\t6 - COLLECTIONS -> HASH-MAP";
		menu += "\n\t7 - GENERICS E PRÁTICA";

		return menu;
	}

	private static void aprenderWrapper() {

		char letra = Character.valueOf('R');

		boolean verdade = Boolean.parseBoolean("true");
		boolean verdade1 = Boolean.parseBoolean("TRUE");
		boolean verdade2 = Boolean.parseBoolean("tRue");
		boolean falso = Boolean.parseBoolean("T");

		byte inteiroUm = Byte.parseByte("127");
		short inteiroDois = Short.parseShort("129");
		int inteiroTres = Integer.parseInt("10000");
		long inteiroQuatro = Long.parseLong("10000000");

		float decimalUm = Float.parseFloat("144.450");
		// double decimalDois = Double.parseDouble("144,450 "); NÃO FUNCIONA COM VIRGULA

	}

	private static void aprenderEnum() {
		System.out.println("Testando Enum: " + DiasSemana.SABADO);

		boolean hoje = DiasSemana.DOMINGO == DiasSemana.SEGUNDA;
		System.out.println(DiasSemana.DOMINGO == DiasSemana.SEGUNDA ? "Sim" : "Não");

		System.out.println(hoje ? "Sim" : "Não");

		for (int dia = 0; dia < DiasSemana.values().length; dia++) {
			System.out.println((dia + 1) + " - " + DiasSemana.values()[dia]); // NOVO MODO DE FAZER UM MENU

		}

		System.out.println("\n\nGosto desse tipo de personagem: " + PersonagemJogo.SACERDOTE);
		System.out.println(
				"\n Geralmente a classe " + PersonagemJogo.SACERDOTE + " tem HP = " + PersonagemJogo.SACERDOTE.getHP());

		System.out.println("\nO mago está no indice do Enum: [" + PersonagemJogo.MAGO.ordinal() + "]");
		System.out.println("\n Geralmente a classe " + PersonagemJogo.SACERDOTE + " tem como característica = "
				+ PersonagemJogo.SACERDOTE.getDESCRICAO());
		System.out.println("\n" + PersonagemJogo.BARBARO.getDetails());

		for (int personagem = 0; personagem < PersonagemJogo.values().length; personagem++) {
			System.out.println(
					"Contador = " + personagem + " posicao do Enum = " + PersonagemJogo.values()[personagem].ordinal());
			System.out.println("\nO personagem " + PersonagemJogo.values()[personagem].name());
			System.out.println(PersonagemJogo.values()[personagem].getHP());
			System.out.println(PersonagemJogo.values()[personagem].getDESCRICAO());

		}

		for (PersonagemJogo variavel : PersonagemJogo.values()) {
			System.out.println(variavel.ordinal() + " - " + variavel.getDetails());
		}
		System.out.println("\tO Druida está na posição [" + PersonagemJogo.DRUIDA.ordinal() + "]");
	}

}
