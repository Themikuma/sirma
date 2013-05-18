package com.sirma.itt.javacourse.intro;

import java.util.regex.Pattern;

/**
 * A final class that cannot be inherited or instantiated.
 * 
 * @author user
 */
public final class StringNumberChecker {
	private static final Pattern REGEX = Pattern.compile("[0-9]+");

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
			throw new NullPointerException("The input string cannot be null");
		}
		if (input.length() == 0) {
			throw new NumberFormatException("The input string cannot be empty");
		}
		if (!REGEX.matcher(input).matches()) {
			throw new NumberFormatException("The input string must consist of numbers only");
		}
		return true;

	}
}
