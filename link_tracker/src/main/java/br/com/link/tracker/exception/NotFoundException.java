package br.com.link.tracker.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2046925152232510009L;

	public NotFoundException(String message) {
		super(message);
	}

}
