package be.vdab.frituurfrita.exceptions;

public class SnackNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public SnackNotFoundException() {
		super();
	}
	public SnackNotFoundException(String message) {
		super(message);
	}
}
