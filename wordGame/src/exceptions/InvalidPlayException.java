package exceptions;

public class InvalidPlayException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidPlayException() {
		super("Play entered is invalid");
	}
}
