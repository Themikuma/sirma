package com.sirma.itt.javacourse.refanreg;

public class EmailValidator {

	public boolean isEmailValid(String email) {
		if (email.matches("[a-zA-Z][a-zA-Z0-9.-]*[@][a-zA-Z0-9.-]")) {
			return true;
		}
		return false;
	}
}
