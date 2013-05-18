package com.sirma.itt.javacourse.refanreg.task5;

/**
 * An email validator class that checks if an email is valid with regex.
 * 
 * @author user
 */
public final class EmailValidator {
	/**
	 * A private constructor, overriding the default one, so the class can't be initialized.
	 */
	private EmailValidator() {

	}

	/**
	 * Checking if the input email is valid with regex.
	 * 
	 * @param email
	 *            the email to be checked
	 * @return true if it is valid, false otherwise
	 */
	// TODO make sure that the email ends in .{2-4} characters
	public static boolean isEmailValid(String email) {
		if (email.matches("[a-zA-Z][a-zA-Z0-9.-]*[@][a-zA-Z0-9.-]*")) {
			return true;
		}
		return false;
	}
}
