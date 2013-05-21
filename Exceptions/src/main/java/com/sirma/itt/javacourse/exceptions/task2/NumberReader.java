package com.sirma.itt.javacourse.exceptions.task2;

import java.util.Scanner;

/**
 * Class with a method that will read one number from the console.
 * 
 * @author user
 */
public class NumberReader {

	/**
	 * An overload of the method that is going to read from the console.
	 */
	public void readNumber() {
		try (Scanner in = new Scanner(System.in)) {
			while (in.hasNextInt()) {
				checkNumber(in.nextInt());
			}
		}
	}

	/**
	 * Method that checks if the number is in the correct range.
	 * 
	 * @param number
	 *            the number which is going to be checked
	 */
	public void checkNumber(int number) {
		if (number < 0 || number > 100) {
			throw new OutOfBoundsException("The number must be in the range 0-100");
		}
	}
}
