package br.com.entra21.javaavancado.principal.aula07;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.entra21.javaavancado.principal.Aula;

public class Aula07 extends Aula {

	public Aula07(String titulo, ArrayList<String> assuntos) {
		super(titulo, assuntos);

	}

	@Override
	public byte capturarOpcao() {

		byte opcao = super.capturarOpcao();

		switch (opcao) {
		case 1:
			aprenderTratarErros();
			break;
		case 2:
			aprenderDetalheErro();
			break;

		case 3:
			usarCustomException();

			break;

		default:
			System.out.println("\n---------------OP��O INV�LIDA PARA AULA 07---------------");
			break;
		}

		return opcao;
	}

	private void aprenderTratarErros() {
		Scanner entrada = new Scanner(System.in);

		try {
			System.out.println("\nInforme um n�mero n�o muito alto, por favor: \n");
			byte naoEstouPreparado = entrada.nextByte();
		} catch (InputMismatchException e) {

			System.out.println("N�o vou parar o projeto s� por causa desse errinho!!!");
			System.out.println("Voc� vai capturar at� dar certo!");
			aprenderTratarErros();
		}

	}

	private void aprenderDetalheErro() {

		Scanner entrada = new Scanner(System.in);

		try {
			System.out.println("\nINFORME UM VALOR PEQUENO: ");
			byte estouPreparado = entrada.nextByte();
		} catch (InputMismatchException e) {

			System.out.println("\nVoc� n�o sabia mas eu estava preparado para essa situa��o -> " + e.getMessage()
					+ " ou -> " + e.getCause());

		}

	}

	private void usarCustomException() {

		Scanner entrada = new Scanner(System.in);
		try {
			System.out.println("Informe sua data de nascimento no formato YYYY-MM-DD: ");
			LocalDate dataNascimento = LocalDate.parse(entrada.next());
			if(dataNascimento.isAfter(LocalDate.now())) {
				throw new DataFuturaNaoPermitidaException();
			} 
			if(dataNascimento.isEqual(LocalDate.now())) {
				throw new DataFuturaNaoPermitidaException("Voc� nasceu hoje? ");
			}
		} catch (DateTimeParseException e) {
			System.out.println("Tem alguma coisa errada com essa data, motivo -> " + e.getMessage());
		} catch (DataFuturaNaoPermitidaException e) {
			System.out.println(e.getMessage());

		}

	}
}
