package fr.aston.vtc.exception;

public class FacturationNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public FacturationNotFoundException(String message) {
		super(message);
	}
}
