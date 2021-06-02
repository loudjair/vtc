package fr.aston.vtc.exception;

public class UserNotFoundExecption extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundExecption(String message) {
		super(message);
	}
}
