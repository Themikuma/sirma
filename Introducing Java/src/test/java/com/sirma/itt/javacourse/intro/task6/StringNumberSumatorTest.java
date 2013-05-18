package com.sirma.itt.javacourse.intro.task6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class, testing the NumberAddition Class.
 * 
 * @author user
 */
public class StringNumberSumatorTest {
	/**
	 * Testing the addClass method from the NumberAddition class. The tests should return the
	 * expected sum.
	 */
	@Test
	public void testSum() {
		StringNumberSumator addClass = new StringNumberSumator();
		assertEquals("67868778555572961", addClass.sum("91686886861", "67868686868686100"));
		assertEquals("2", addClass.sum("1", "1"));
		assertEquals("1998", addClass.sum("999", "999"));
		assertEquals("9968", addClass.sum("9753", "215"));
	}

	/**
	 * Testing the addClass method from the NumberAddition class for NumberFormatException.
	 */
	@Test(expected = NumberFormatException.class)
	public void testSumException() {
		StringNumberSumator addClass = new StringNumberSumator();
		addClass.sum("a21", "211");
		addClass.sum("", "211");
	}

	/**
	 * Testing the addClass method from the NumberAddition class for NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testSumNullPointerException() {
		StringNumberSumator addClass = new StringNumberSumator();
		addClass.sum(null, "2");
	}

}
