package com.sirma.itt.javacourse.intro;

/**
 * A final class that cannot be inherited or instantiated.
 * 
 * @author user
 */
public final class StringNumberChecker {
	/**
	 * Private constructor, overriding the default one, disallowing the instantiation of the class.
	 */
	private StringNumberChecker() {
	}

	/**
	 * Method, checking if the input string is empty, null or contains other symbols than numbers.
	 * 
	 * @param input
	 *            the input string
	 * @return true if the String is a not null, empty or not a number
	 */
	public static boolean isStringNumber(String input) {
		if (input == null) {
			throw new IllegalArgumentException("The input string cannot be null");
		}
		if (input.length() == 0) {
			throw new IllegalArgumentException("The input string cannot be empty");
		}
		if (!input.matches("[0-9]+")) {
			throw new IllegalArgumentException("The input string must consist of numbers only");
		}
		return true;

	}
}
