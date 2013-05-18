package com.sirma.itt.javacourse.intro.task235;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A class testing the methods from the class ArrayProcessing.
 * 
 * @author metodskiPC
 */
public class IntegerArrayProcessorTest {

	private static IntegerArrayProcessor arrayClass;

	/**
	 * Initializes the class.
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		arrayClass = new IntegerArrayProcessor();

	}

	/**
	 * Method, testing the method getMinElement from the ArrayProcessing class.
	 */
	@Test
	public void testGetMinElement() {
		assertEquals(1, arrayClass.findMinElement(new int[] { 1, 2, 3, 4, 5 }));
		assertEquals(-5, arrayClass.findMinElement(new int[] { 1, 2, -5, 4, 5 }));
		assertEquals(-5, arrayClass.findMinElement(new int[] { -5, -3, -2, -1, -5 }));
	}

	/**
	 * Method, testing the method getMinElement from the ArrayProcessing class for
	 * IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetMinElementIllegalArgumentException() {
		arrayClass.findMinElement(new int[] {});
	}

	/**
	 * Method, testing the method getMinElement from the ArrayProcessing class for
	 * NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetMinElementNullPointerException() {
		arrayClass.findMinElement(null);
	}

	/**
	 * Method, testing the method getSum from the ArrayProcessing class.
	 */
	@Test
	public void testGetSum() {
		assertEquals(20, arrayClass.getSum(new int[] { 10, 10 }));
		assertEquals(5, arrayClass.getSum(new int[] { 1, 1, 1, 1, 1 }));
	}

	/**
	 * Method, testing the method getSum from the ArrayProcessing class for
	 * IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testgetSumIllegalArgumentException() {
		arrayClass.getSum(new int[] {});
	}

	/**
	 * Method, testing the method getSum from the ArrayProcessing class for NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testgetSumNullPointerException() {
		arrayClass.getSum(null);
	}

	/**
	 * Testing the centerOfMass method.
	 */
	@Test
	public void testCenterOfMass() {
		assertEquals(4, arrayClass.findCenterOfMass(new int[] { 1, 2, 3, 4, 5 }));
		assertEquals(4, arrayClass.findCenterOfMass(new int[] { 1, 1, 1, 100, 1, 1 }));
		assertEquals(2, arrayClass.findCenterOfMass(new int[] { 0, 5, 0 }));
		assertEquals(4, arrayClass.findCenterOfMass(new int[] { 100, 0, 0, 300 }));
		assertEquals(3, arrayClass.findCenterOfMass(new int[] { 1, 1, 1, 1 }));
	}

	/**
	 * Method, testing the method centerOfMass from the MassOfArray class for
	 * IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenterOfMassIllegalArgumentException() {
		arrayClass.findCenterOfMass(new int[] {});
	}

	/**
	 * Method, testing the method centerOfMass from the MassOfArray class for NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testCenterOfMassNullPointerException() {
		arrayClass.findCenterOfMass(null);
	}

	/**
	 * Testing the reverseArray method from the ReverseArray class.
	 */
	@Test
	public void testReverseArray() {
		assertTrue(Arrays.equals(new int[] { 5, 4, 3, 2, 1 },
				arrayClass.reverseArray(new int[] { 1, 2, 3, 4, 5 })));
		assertTrue(Arrays.equals(new int[] { 1, 2 }, arrayClass.reverseArray(new int[] { 2, 1 })));
		assertTrue(Arrays.equals(new int[] { 20, 30, 1, 0, 5 },
				arrayClass.reverseArray(new int[] { 5, 0, 1, 30, 20 })));
	}

	/**
	 * Testing the reverseArray method from the ReverseArray class for IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testReverseArrayIllegalArgumentException() {
		arrayClass.reverseArray(new int[] {});
	}

	/**
	 * Testing the reverseArray method from the ReverseArray class for NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testReverseArrayException() {
		arrayClass.reverseArray(null);
	}

}
