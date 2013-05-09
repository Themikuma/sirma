package com.sirma.itt.javacourse.intro.task7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class, testing the RandomString class.
 * 
 * @author user
 */
public class RandomStringGeneratorTest {

	/**
	 * Testing the generateString method. We can't test for returned random values so we are testing
	 * for the returned random string's length.
	 */
	@Test
	public void testGenerateString() {
		RandomStringGenerator randomClass = new RandomStringGenerator();
		assertEquals(10, randomClass.generateString(10).length());
	}
}
