package br.com.link.tracker.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -4046955152232510009L;

	public BusinessException(String message) {
		super(message);
	}

}
