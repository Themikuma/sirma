package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

/**
 * A class testing the methods from the class ArrayProcessing.
 * 
 * @author metodskiPC
 */
public class ArrayProcessingTest {

	private ArrayProcessing arrayClass;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	/**
	 * Initializes the class and sets a new output stream.
	 * 
	 * @throws Exception
	 *             exception if anything goes wrong
	 */
	@Before
	public void setUp() throws Exception {
		arrayClass = new ArrayProcessing();
		System.setOut(new PrintStream(outContent));

	}

	/**
	 * Method, testing the method getMinElement from the ArrayProcessing class.
	 */
	@Test
	public void testGetMinElement() {
		assertEquals(1, arrayClass.getMinElement(new int[] { 1, 2, 3, 4, 5 }));
		assertEquals(-5, arrayClass.getMinElement(new int[] { 1, 2, -5, 4, 5 }));
		assertEquals(-5, arrayClass.getMinElement(new int[] { -5, -3, -2, -1, -5 }));
	}

	/**
	 * Method, testing the method getMinElement from the ArrayProcessing class for exceptions.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetMinElementException() {
		assertEquals("Can't handle null arrays", arrayClass.getMinElement(new int[] {}));
		assertEquals("Can't handle null arrays", arrayClass.getMinElement(null));
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

}
