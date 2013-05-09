package com.sirma.itt.javacourse.exceptions.task3;

/**
 * Custom exception class for when the array is empty and we are trying to remove an element.
 * 
 * @author user
 */
public class EmptyArrayException extends RuntimeException {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 6831448724609165953L;

	/**
	 * Constructor for when the exception is thrown without any particular message.
	 */
	public EmptyArrayException() {

	}

	/**
	 * Constructor for when the exception is thrown with a message.
	 * 
	 * @param message
	 *            the message of the exception
	 */
	public EmptyArrayException(String message) {
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
	public EmptyArrayException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor for when the exception is thrown and the cause is specified.
	 * 
	 * @param cause
	 *            the cause of the exception
	 */
	public EmptyArrayException(Throwable cause) {
		super(cause);
	}
}
