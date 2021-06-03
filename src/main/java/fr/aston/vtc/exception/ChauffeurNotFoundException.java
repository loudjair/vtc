package fr.aston.vtc.exception;

public class ChauffeurNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ChauffeurNotFoundException(String message) {
		super(message);
	}
}
