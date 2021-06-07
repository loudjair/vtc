package fr.aston.vtc.exception;

public class TrajetNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TrajetNotFoundException(String message) {
		super(message);
	}
	
}
