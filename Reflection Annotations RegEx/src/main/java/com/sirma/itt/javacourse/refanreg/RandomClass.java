package com.sirma.itt.javacourse.refanreg;

/**
 * @author user
 */
public class RandomClass {
	public String publicString;
	private int privateInt;
	protected boolean protectedBool;
	char defaultChar;

	public RandomClass() {
		publicString = "public string";
		privateInt = 1;
		protectedBool = true;
		defaultChar = 'a';
	}

	public void publicMethod() {
	}

	private void privateMethod() {
	}

	protected void protectedMethod() {
	}

	void defaultMethod() {
	}
}
