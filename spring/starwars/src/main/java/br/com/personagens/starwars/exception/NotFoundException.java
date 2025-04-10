package br.com.personagens.starwars.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7937570051313917268L;

	public NotFoundException() {
	}

	public NotFoundException(String message) {
		super(message);
	}
}
