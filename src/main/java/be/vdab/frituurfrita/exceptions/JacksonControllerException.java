package be.vdab.frituurfrita.exceptions;

public class JacksonControllerException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JacksonControllerException() {
		super();
	}
	
	public JacksonControllerException(String message) {
		super(message);
	}
}
