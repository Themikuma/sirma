package com.sirma.itt.javacourse.inputoutput.task1;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import org.junit.Test;

/**
 * Class, testing the ConsoleReader class.
 * 
 * @author user
 */
public class ConsoleReaderTest {

	/**
	 * Testing the readString method of the ConsoleReader class for correct input with custom
	 * inputarray.
	 */
	@Test
	public void testReadString() {
		ByteArrayInputStream input = new ByteArrayInputStream("message qwe".getBytes());
		String result = ConsoleReader.readString(input);
		assertEquals("message qwe", result);
	}

	/**
	 * Testing the readInt method of the ConsoleReader class for correct input with custom
	 * inputarray.
	 */
	@Test
	public void testReadInt() {
		ByteArrayInputStream input = new ByteArrayInputStream("25".getBytes());
		int result = ConsoleReader.readInt(input);
		assertEquals(25, result);
	}

	/**
	 * Testing the readint method of the ConsoleReader class for InputMismatchException.
	 */
	@Test(expected = InputMismatchException.class)
	public void testReadIntException() {
		ByteArrayInputStream input = new ByteArrayInputStream("2w".getBytes());
		int result = ConsoleReader.readInt(input);
		assertEquals(25, result);
	}

	/**
	 * Testing the readChar method of the ConsoleReader class for correct input with custom
	 * inputarray.
	 */
	@Test
	public void testReadChar() {
		ByteArrayInputStream input = new ByteArrayInputStream("w".getBytes());
		char result = ConsoleReader.readChar(input);
		assertEquals('w', result);
	}

	/**
	 * Testing the readFloat method of the ConsoleReader class for correct input with custom
	 * inputarray.
	 */
	@Test
	public void testReadFloat() {
		ByteArrayInputStream input = new ByteArrayInputStream("25,43".getBytes());
		float result = ConsoleReader.readFloat(input);
		assertEquals(25.43, result, 0.1);
	}

	/**
	 * Testing the readFloat method of the ConsoleReader class for exceptions.
	 */
	@Test(expected = InputMismatchException.class)
	public void testReadFloatException() {
		ByteArrayInputStream input = new ByteArrayInputStream("25a,43".getBytes());
		float result = ConsoleReader.readFloat(input);
		assertEquals(25.43, result, 0.1);
	}

}
