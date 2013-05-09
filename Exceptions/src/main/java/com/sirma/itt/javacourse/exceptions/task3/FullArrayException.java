package com.sirma.itt.javacourse.exceptions.task3;

/**
 * Exception class, thrown when the array is full and we are trying to add an element.
 * 
 * @author user
 */
public class FullArrayException extends RuntimeException {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -8800438033871734670L;

	/**
	 * Constructor for when the exception is thrown without any particular message.
	 */
	public FullArrayException() {
	}

	/**
	 * Constructor for when the exception is thrown with a message.
	 * 
	 * @param message
	 *            the message of the exception
	 */
	public FullArrayException(String message) {
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
	public FullArrayException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor for when the exception is thrown and the cause is specified.
	 * 
	 * @param cause
	 *            the cause of the exception
	 */
	public FullArrayException(Throwable cause) {
		super(cause);
	}
}
