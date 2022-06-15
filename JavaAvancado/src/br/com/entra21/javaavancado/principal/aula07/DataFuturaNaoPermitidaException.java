package br.com.entra21.javaavancado.principal.aula07;

import java.time.LocalDate;

public class DataFuturaNaoPermitidaException extends Exception {

	public DataFuturaNaoPermitidaException() {
		super("Não é permitido informar uma data maior que hoje "+LocalDate.now().toString());

	}

	public DataFuturaNaoPermitidaException(String mensagem) {
		super(mensagem);

	}

}
