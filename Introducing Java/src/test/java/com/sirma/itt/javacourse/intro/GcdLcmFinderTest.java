package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class with methods testing the functionality of the Gcd class.
 * 
 * @author metodskiPC
 */
public class GcdLcmFinderTest {

	/**
	 * Method, testing the functionality of the Gcd class, gcd method.
	 */
	@Test
	public void testGcd() {
		GcdLcmFinder greatestDivisor = new GcdLcmFinder();
		assertEquals(2, greatestDivisor.findGcd(20, 2));
		assertEquals(4, greatestDivisor.findGcd(20, 4));
		assertEquals(12, greatestDivisor.findGcd(1332, 600));
	}

	/**
	 * Method, testing the functionality of the Gcd class, lcm method.
	 */
	@Test
	public void testLcm() {
		GcdLcmFinder test = new GcdLcmFinder();
		assertEquals(315, test.findLcm(63, 5));
		assertEquals(55, test.findLcm(11, 5));
	}

}
