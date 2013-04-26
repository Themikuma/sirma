package com.sirma.itt.javacourse.refanreg;

public class PrivateClass {

	private String changeMe;

	public PrivateClass() {
		changeMe = "hello";
	}

	private void callMe() {
		System.out.println("I have been summoned!");
	}

}
