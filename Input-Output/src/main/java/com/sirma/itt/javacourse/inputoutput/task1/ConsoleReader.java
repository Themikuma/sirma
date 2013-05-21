package com.sirma.itt.javacourse.inputoutput.task1;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class, containing methods for reading input from the console.
 * 
 * @author user
 */
public final class ConsoleReader {

	/**
	 * A private constructor disallowing the instantiation of this class.
	 */
	private ConsoleReader() {
	}

	/**
	 * Reads a string from the console.
	 * 
	 * @return the red string
	 */
	public static String readString() {
		return readString(System.in);
	}

	/**
	 * Overload method reading a string for testing purposes from a custom InputStream instead of
	 * from the console.
	 * 
	 * @param in
	 *            the custom {@link InputStream}
	 * @return the red string
	 */
	public static String readString(InputStream in) {
		try (Scanner reader = new Scanner(in)) {
			return reader.nextLine();
		}
	}

	/**
	 * Reads an integer from the console.
	 * 
	 * @return the red integer
	 */
	public static int readInt() {
		return readInt(System.in);
	}

	/**
	 * Overload method reading an integer from a custom InputStream instead of from the console.
	 * 
	 * @param in
	 *            the custom {@link InputStream}
	 * @return the red integer
	 */
	public static int readInt(InputStream in) {
		try (Scanner reader = new Scanner(in)) {
			return reader.nextInt();
		}
	}

	/**
	 * Reads a char from the console.
	 * 
	 * @return the red char
	 */
	public static char readChar() {
		return readChar(System.in);
	}

	/**
	 * Overload method reading a float from a custom {@link InputStream} instead of from the
	 * console.
	 * 
	 * @param in
	 *            the custom {@link InputStream}
	 * @return the red float
	 */
	public static char readChar(InputStream in) {
		try (Scanner reader = new Scanner(in)) {
			return reader.next().charAt(0);
		}
	}

	/**
	 * Reads a float from the console.
	 * 
	 * @return the red float
	 */
	public static float readFloat() {
		return readFloat(System.in);
	}

	/**
	 * Overload method reading a float from a custom InputStream instead of from the console.
	 * 
	 * @param in
	 *            the custom {@link InputStream}ream
	 * @return the red float
	 */
	public static float readFloat(InputStream in) {
		try (Scanner reader = new Scanner(in)) {
			return reader.nextFloat();
		}
	}

}
