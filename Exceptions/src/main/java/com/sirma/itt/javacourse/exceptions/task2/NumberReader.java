package com.sirma.itt.javacourse.exceptions.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class with a method that will read one number from the console.
 * 
 * @author user
 */
public class NumberReader {

	/**
	 * Method that reads a number from the console and checks if its a valid number and if it's in
	 * the correct range.
	 * 
	 * @throws OutOfBoundsException
	 *             Exception for when the number is smaller than 0 or higher than 100
	 */
	// TODO create tests for this method.
	public void readNumber() throws OutOfBoundsException {
		java.io.InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		int number = 0;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			number = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.out.println("This is not a valid number");
		}
		if (number < 0 || number > 100) {
			throw new OutOfBoundsException("The number must be in the range 0-100");
		}
	}
}
