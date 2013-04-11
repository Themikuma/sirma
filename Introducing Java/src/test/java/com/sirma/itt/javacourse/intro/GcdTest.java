package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class with a method, testing the functionality of the Gcd class.
 * 
 * @author metodskiPC
 */
public class GcdTest {

	/**
	 * Method, testing the functionality of the Gcd class.
	 */
	@Test
	public void testGcd() {
		Gcd greatestDivisor = new Gcd();
		assertEquals(2, greatestDivisor.gcd(20, 2));
		assertEquals(4, greatestDivisor.gcd(20, 4));
		assertEquals(12, greatestDivisor.gcd(1332, 600));
	}

}
