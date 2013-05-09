package com.sirma.itt.javacourse.refanreg.task3;

/**
 * A random class for the purpose of the assignment, containing random fields and methods.
 * 
 * @author user
 */
public class PrivateClass {

	private String changeMe;

	/**
	 * A constructor, setting the value of the changeMe string.
	 */
	public PrivateClass() {
		setChangeMe("hello");
	}

	/**
	 * A private method, that must be called outside of this class using reflections.
	 */
	@SuppressWarnings("unused")
	private void callMe() {
		System.out.println("I have been summoned!");
	}

	/**
	 * Getter method for changeMe.
	 * 
	 * @return the changeMe
	 */
	public String getChangeMe() {
		return changeMe;
	}

	/**
	 * Setter method for changeMe.
	 * 
	 * @param changeMe
	 *            the changeMe to set
	 */
	public void setChangeMe(String changeMe) {
		this.changeMe = changeMe;
	}

}
