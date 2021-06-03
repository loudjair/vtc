package fr.aston.vtc.exception;

public class VehiculeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public VehiculeNotFoundException(String message) {
		super(message);
	}
}