package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A class testing the quickSort method from the QuickSort class.
 * 
 * @author metodskiPC
 */
public class QuickSortTest {

	private static QuickSort sortClass;

	/**
	 * Setting up the QuickSort class before the tests.
	 * 
	 * @throws Exception
	 *             exception if something goes wrong
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sortClass = new QuickSort();
	}

	/**
	 * Testing the quickSort method.
	 */
	@Test
	public void testQuickSort() {
		assertTrue(Arrays.equals(new int[] { 1, 1, 2, 5, 20 },
				sortClass.quickSort(new int[] { 2, 5, 1, 20, 1 })));
		assertTrue(Arrays.equals(new int[] { 5, 10, 20, 30, 40, 50 },
				sortClass.quickSort(new int[] { 20, 10, 30, 5, 50, 40 })));
	}

	/**
	 * Testing the quickSort method for exceptions(empty/null array).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testQuickSortException() {
		assertEquals("Can't handle null arrays", sortClass.quickSort(new int[] {}));
		assertEquals("Can't handle null arrays", sortClass.quickSort(null));
	}
}
