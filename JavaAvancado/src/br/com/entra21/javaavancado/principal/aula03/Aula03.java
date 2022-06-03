package br.com.entra21.javaavancado.principal.aula03;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.entra21.javaavancado.principal.aula03.assuntos.Anotacao;

public class Aula03 {

	static Scanner input = new Scanner(System.in);

	
	public static void aprender() {

		byte option;

		do {
			System.out.println("\t0 - VOLTAR");
			System.out.println("\t1 - DATAS");
			System.out.println("\t2 - ANNOTATIONS");
			System.out.println("\t3 - ENCERRAR");
			option = input.nextByte();

			switch (option) {
			case 0:
				System.out.println("\t\t\t\t...RETORNANDO AO MENU PRINCIPAL...");
				break;
			case 1:
				aprenderDatas();
				break;
			case 2:
				aprenderAnnotations();
				break;
			case 3:
				System.exit(0); // O exit retorna um valor para quem chamou o programa
				break;

			default:

				System.out.println("POR FAVOR, SELECIONE UMA OPÇAO VÁLIDA!");
				break;
			}

		} while (option != 0);

	}

	@Anotacao
	private static void aprenderDatas() {

		Instant start = Instant.now();
		// -------------------------------//

		System.out.println("Escolha um número aleatório... Menos esse daí que voce está pensando!!!!");

		long number = input.nextLong();

		// -------------------------------//
		Instant finish = Instant.now();

		Duration time = Duration.between(start, finish);
		System.out.println("Você demorou " + time.toSeconds() + " segundos para escolher o número " + number);
		System.out.println("Para datas, levamos: " + time.toSeconds() + " segundos");

		aprenderDatasHumanizadas();

	}

	private static void aprenderDatasHumanizadas() {

		LocalDate today = LocalDate.now();
		System.out.println("Hoje é: " + today);

		LocalDate birthday = LocalDate.of(1994, 8, 3);
		System.out.println("Seu aniversário é: " + birthday);

		LocalDate thisThursday = LocalDate.of(2022, Month.JUNE, 3); // Month.JUNE -> ENUM.
		System.out.println("Essa Quinta: " + thisThursday);

		// Formata a data para uma melhor visualização
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YY"); // MMM aparece o mes(august)
		System.out.println("\n" + formatter.format(birthday));

		System.out.println("----------\n" + DateTimeFormatter.ofPattern("YYYY").format(thisThursday));

		Period lifetime = Period.between(birthday, today);
		System.out.println("\nEu vivi um total de: " + lifetime.getYears() + " anos, " + lifetime.getMonths()
				+ " meses e " + lifetime.getDays() + " dias.");

		LocalTime lanche = LocalTime.of(20, 10);
		LocalTime finalAula03 = LocalTime.of(22, 15);
		LocalTime avaliacao = LocalTime.of(22, 0);

		System.out.println("Fomos lanchar as: " + lanche + " Vamos avaliar a aula as " + avaliacao
				+ " temos que aprender tudo até " + finalAula03);

	}

	private static void aprenderAnnotations() {

	}

}
