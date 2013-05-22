package com.sirma.itt.javacourse.collections.task3;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * A class containing a {@link HashMap} with exceptions and a message string with added exceptions.
 * 
 * @author user
 */
public class ExceptionMessageManager {
	private Map<String, String> exceptions = new HashMap<String, String>();
	private String message = "";
	private final String separator = "@";

	/**
	 * Setting the exceptions in the hashmap.
	 */
	public ExceptionMessageManager() {
		exceptions.put("Invalid Number", "Invalid credit card number");
		exceptions.put("Invalid ID", "Invalid identity document number");
		exceptions.put("Invalid PC", "Invalid postal code");
	}

	/**
	 * Adding an exception from the hashmap to the message string by its value.
	 * 
	 * @param messageCode
	 *            the value of the exception to be added to the message string
	 */
	public void addExceptionMessage(String messageCode) {
		if (exceptions.containsValue(messageCode)) {
			if ("".equals(message)) {
				message += messageCode;
			} else
				message += separator + messageCode;
		} else
			throw new NoSuchElementException("The exception doesn't exist");
	}

	/**
	 * Adding an exception from the hashmap to the message string by its key.
	 * 
	 * @param messageCode
	 *            the key of the exception to be added to the message string
	 */
	public void addExceptionMessageUsingCode(String messageCode) {
		if (exceptions.containsKey(messageCode)) {
			if ("".equals(message)) {
				message += exceptions.get(messageCode);
			} else
				message += separator + exceptions.get(messageCode);
		} else
			throw new NoSuchElementException("The exception doesn't exist");
	}

	/**
	 * Splits the message string by its separator into a List.
	 * 
	 * @param messageCombination
	 *            the message string to be split
	 * @return the split message
	 */
	public static Collection<String> getMessages(String messageCombination) {
		String[] exceptionMessages = messageCombination.split("@");
		return Arrays.asList(exceptionMessages);
	}

	/**
	 * Getter method for exceptions.
	 * 
	 * @return the exceptions
	 */
	public Map<String, String> getExceptions() {
		return exceptions;
	}

	/**
	 * Setter method for exceptions.
	 * 
	 * @param exceptions
	 *            the exceptions to set
	 */
	public void setExceptions(Map<String, String> exceptions) {
		this.exceptions = exceptions;
	}

	/**
	 * Getter method for message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter method for message.
	 * 
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
