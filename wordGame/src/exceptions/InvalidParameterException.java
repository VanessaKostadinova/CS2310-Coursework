package exceptions;

/**
 * A custom exception for invalid parameters.
 * 
 * @author Vanessa Kostadinova
 * @version 24/11/2019
 */

public class InvalidParameterException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidParameterException(String str) {
		super(str);
	}

}
