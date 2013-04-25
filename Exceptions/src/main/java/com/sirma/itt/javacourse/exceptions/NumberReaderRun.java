package com.sirma.itt.javacourse.exceptions;

/**
 * Run class using the NumberReader class's methods.
 * 
 * @author user
 */
public final class NumberReaderRun {

	/**
	 * Private constructor so the class cannot be instantiated.
	 */
	private NumberReaderRun() {

	}

	/**
	 * Static main method from which the program will start.
	 * 
	 * @param args
	 *            console-line arguments
	 */
	public static void main(String[] args) {
		NumberReader reader = new NumberReader();
		while (true) {
			try {
				reader.readNumber();
			} catch (OutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
