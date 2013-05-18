package com.sirma.itt.javacourse.intro.task4;

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
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
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
	 * Testing the quickSort method for IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testQuickSortIllegalArgumentException() {
		sortClass.quickSort(new int[] {});
	}

	/**
	 * Testing the quickSort method for NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testQuickSortNullPointerException() {
		sortClass.quickSort(null);
	}
}
