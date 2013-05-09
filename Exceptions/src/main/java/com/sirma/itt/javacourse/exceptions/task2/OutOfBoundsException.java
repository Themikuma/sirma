package com.sirma.itt.javacourse.exceptions.task2;

/**
 * An exception class that is thrown when the number is smaller than 0 or higher than 100.
 * 
 * @author user
 */
public class OutOfBoundsException extends Exception {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -4988545177966189005L;

	/**
	 * Constructor for when the exception is thrown without any particular message.
	 */
	public OutOfBoundsException() {
	}

	/**
	 * Constructor for when the exception is thrown with a message.
	 * 
	 * @param message
	 *            the message of the exception
	 */
	public OutOfBoundsException(String message) {
		super(message);
	}

	/**
	 * Constructor for when the exception is thrown with a message and the cause is specified.
	 * 
	 * @param message
	 *            the message of the exception
	 * @param cause
	 *            the cause of the exception
	 */
	public OutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor for when the exception is thrown and the cause is specified.
	 * 
	 * @param cause
	 *            the cause of the exception
	 */
	public OutOfBoundsException(Throwable cause) {
		super(cause);
	}

}
