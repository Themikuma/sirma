package com.sirma.itt.javacourse.exceptions;

public class NumberReaderRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberReader reader = new NumberReader();
		try {
			reader.readNumber();
		} catch (OutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
