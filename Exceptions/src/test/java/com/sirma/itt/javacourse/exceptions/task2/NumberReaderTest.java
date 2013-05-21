package com.sirma.itt.javacourse.exceptions.task2;

import org.junit.Test;

/**
 * Testing the {@link NumberReader} class.
 * 
 * @author user
 */
public class NumberReaderTest {

	/**
	 * Testing the method for normal execution.
	 */
	@Test
	public void testReadNumber() {
		NumberReader reader = new NumberReader();
		reader.checkNumber(20);
		reader.checkNumber(0);
		reader.checkNumber(100);

	}

	/**
	 * Testing the method for exception.
	 */
	@Test(expected = OutOfBoundsException.class)
	public void testReadNumberException() {
		NumberReader reader = new NumberReader();
		reader.checkNumber(102);

	}

}
