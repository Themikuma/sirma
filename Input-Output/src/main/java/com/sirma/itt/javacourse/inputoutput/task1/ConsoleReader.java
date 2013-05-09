package com.sirma.itt.javacourse.inputoutput.task1;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class, containing methods for reading input from the console.
 * 
 * @author user
 */
public class ConsoleReader {
	private static Scanner reader;

	/**
	 * Reads a string from the console.
	 * 
	 * @return the red string
	 */
	public static String readString() {
		reader = new Scanner(System.in);
		String stringInput = reader.nextLine();
		reader.close();
		reader = null;
		return stringInput;
	}

	/**
	 * Overload method reading a string for testing purposes from a custom InputStream instead of
	 * from the console.
	 * 
	 * @param in
	 *            the custom inputstream
	 * @return the red string
	 */
	public static String readString(InputStream in) {
		reader = new Scanner(in);
		String stringInput = reader.nextLine();
		reader.close();
		reader = null;
		return stringInput;
	}

	/**
	 * Reads an int from the console.
	 * 
	 * @return the red int
	 */
	public static int readInt() {
		reader = new Scanner(System.in);
		if (!reader.hasNextInt()) {
			throw new IllegalArgumentException("That is not a number");
		}
		int intInput = reader.nextInt();
		reader.close();
		reader = null;
		return intInput;
	}

	/**
	 * Overload method reading an int from a custom InputStream instead of from the console.
	 * 
	 * @param in
	 *            the custom inputstream
	 * @return the red int
	 */
	public static int readInt(InputStream in) {
		reader = new Scanner(in);
		if (!reader.hasNextInt()) {
			throw new IllegalArgumentException("That is not a number");
		}
		int intInput = reader.nextInt();
		reader.close();
		reader = null;
		return intInput;
	}

	/**
	 * Reads a char from the console.
	 * 
	 * @return the red char
	 */
	public static char readChar() {
		reader = new Scanner(System.in);
		char charInput = reader.next().charAt(0);
		reader.close();
		reader = null;
		return charInput;
	}

	/**
	 * Ovearload method reading a float from a custom inputstream instead of from the console.
	 * 
	 * @param in
	 *            the custom inputstream
	 * @return the red float
	 */
	public static char readChar(InputStream in) {
		reader = new Scanner(in);
		char charInput = reader.next().charAt(0);
		reader.close();
		reader = null;
		return charInput;
	}

	/**
	 * Reads a float from the console.
	 * 
	 * @return the red float
	 */
	public static float readFloat() {
		reader = new Scanner(System.in);
		if (!reader.hasNextFloat()) {
			throw new IllegalArgumentException("That is not a float");
		}
		float floatInput = reader.nextFloat();
		reader.close();
		reader = null;
		return floatInput;
	}

	/**
	 * Overload method reading a float from a custom InputStream instead of from the console.
	 * 
	 * @param in
	 *            the custom inputstream
	 * @return the red float
	 */
	public static float readFloat(InputStream in) {
		reader = new Scanner(in);
		if (!reader.hasNextFloat()) {
			throw new IllegalArgumentException("That is not a float");
		}
		float floatInput = reader.nextFloat();
		reader.close();
		reader = null;
		return floatInput;
	}

	/**
	 * Getter method for reader.
	 * 
	 * @return the reader
	 */
	public Scanner getReader() {
		return reader;
	}

	/**
	 * Setter method for reader.
	 * 
	 * @param reader
	 *            the reader to set
	 */
	public void setReader(Scanner reader) {
		ConsoleReader.reader = reader;
	}
}
