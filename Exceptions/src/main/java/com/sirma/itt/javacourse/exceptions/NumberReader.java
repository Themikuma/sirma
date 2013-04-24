package com.sirma.itt.javacourse.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberReader {

	public void readNumber() throws OutOfBoundsException {
		java.io.InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		int number = 0;
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
