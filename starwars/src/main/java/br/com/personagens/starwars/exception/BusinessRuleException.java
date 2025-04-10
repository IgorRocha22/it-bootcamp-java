package br.com.personagens.starwars.exception;

public class BusinessRuleException extends RuntimeException {

	private static final long serialVersionUID = 8376493410312215980L;

	public BusinessRuleException() {
	}

	public BusinessRuleException(String message) {
		super(message);
	}
}
