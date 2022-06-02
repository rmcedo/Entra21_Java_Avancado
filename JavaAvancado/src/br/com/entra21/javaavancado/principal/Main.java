package br.com.entra21.javaavancado.principal;

import java.util.Scanner;

import br.com.entra21.javaavancado.principal.aula01.enums.PersonagemJogo;
import br.com.entra21.javaavancado.principal.aula02.collections.list.AprenderCollections;

public class Main {

	static Scanner input = new Scanner(System.in);

	public enum DiasSemana {
		SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO;

	}

	public static void main(String[] args) {
		byte option;

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

			default:
				System.out.println("\n\nPor favor, selecione uma opção válida");
				break;
			}

		} while (option != 0);

	}

	private static String exibirMenu() {

		String menu = "\n\t\tJAVA AVANÇADO!";

		menu += "\n0 - SAIR";
		menu += "\n1 - WRAPPER";
		menu += "\n2 - ENUM";
		menu += "\n3 - COLLECTIONS-LIST";
		menu += "\nESCOLHA UMA DAS OPÇÕES";

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
