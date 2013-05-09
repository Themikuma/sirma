package com.sirma.itt.javacourse.refanreg.task1;

/**
 * A random class containing public, private, protected and default methods and variables for the
 * reflection assignments.
 * 
 * @author user
 */
public class RandomClass {
	public String publicString;
	private int privateInt;
	protected boolean protectedBool;
	char defaultChar;

	/**
	 * A class constructor, assigning some initial values to the variables of the class.
	 */
	public RandomClass() {
		publicString = "public string";
		privateInt = 1;
		protectedBool = true;
		defaultChar = 'a';
	}

	/**
	 * A random public method.
	 */
	public void publicMethod() {
	}

	/**
	 * A random private method.
	 */
	private void privateMethod() {
	}

	/**
	 * A random protected method.
	 */
	protected void protectedMethod() {
	}

	/**
	 * A random default (package-private) method.
	 */
	void defaultMethod() {
	}
}
