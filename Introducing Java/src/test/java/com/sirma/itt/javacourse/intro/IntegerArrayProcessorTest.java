package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A class testing the methods from the class ArrayProcessing.
 * 
 * @author metodskiPC
 */
public class IntegerArrayProcessorTest {

	private static IntegerArrayProcessor arrayClass;
	private static ByteArrayOutputStream outContent;

	/**
	 * Initializes the class and sets a new output stream.
	 * 
	 * @throws Exception
	 *             exception if anything goes wrong
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		arrayClass = new IntegerArrayProcessor();
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

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
	 * Method, testing the method getMinElement from the ArrayProcessing class for exceptions.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetMinElementException() {
		assertEquals("Can't handle null arrays", arrayClass.findMinElement(new int[] {}));
		assertEquals("Can't handle null arrays", arrayClass.findMinElement(null));
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
	 * Method, testing the method getSum from the ArrayProcessing class for exceptions.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testgetSumtException() {
		assertEquals("Can't handle null arrays", arrayClass.getSum(new int[] {}));
		assertEquals("Can't handle null arrays", arrayClass.getSum(null));
	}

	/**
	 * Method, testing the method printElements from the ArrayProcessing class.
	 */
	@Test
	public void testPrintElements() {
		arrayClass.printElements(new int[] { 1, 2, 3, 2, 4, 2, 2, 2 });
		assertEquals("12324222", outContent.toString());
	}

	/**
	 * Method, testing the method printElements from the ArrayProcessing class for exceptions.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPrintElementsException() {
		arrayClass.printElements(new int[] {});
		arrayClass.printElements(null);
		assertEquals("12324222", outContent.toString());
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
	 * Method, testing the method centerOfMass from the MassOfArray class for exceptions.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenterOfMassException() {
		assertEquals("Can't handle null arrays", arrayClass.findCenterOfMass(new int[] {}));
		assertEquals("Can't handle null arrays", arrayClass.findCenterOfMass(null));
	}

}
