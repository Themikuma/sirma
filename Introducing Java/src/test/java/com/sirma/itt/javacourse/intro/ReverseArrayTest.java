package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * Class, testing the ReverseArray's class methods.
 * 
 * @author user
 */
public class ReverseArrayTest {

	/**
	 * Testing the reverseArray method from the ReverseArray class.
	 */
	@Test
	public void testReverseArray() {
		ReverseArray reverseClass = new ReverseArray();
		assertTrue(Arrays.equals(new int[] { 5, 4, 3, 2, 1 },
				reverseClass.reverseArray(new int[] { 1, 2, 3, 4, 5 })));
		assertTrue(Arrays.equals(new int[] { 1, 2 }, reverseClass.reverseArray(new int[] { 2, 1 })));
		assertTrue(Arrays.equals(new int[] { 20, 30, 1, 0, 5 },
				reverseClass.reverseArray(new int[] { 5, 0, 1, 30, 20 })));
	}

	/**
	 * Testing the reverseArray method from the ReverseArray class for exceptions.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testReverseArrayException() {
		ReverseArray reverseClass = new ReverseArray();
		assertEquals("Can't handle null arrays", reverseClass.reverseArray(new int[] {}));
		assertEquals("Can't handle null arrays", reverseClass.reverseArray(null));
	}
}
