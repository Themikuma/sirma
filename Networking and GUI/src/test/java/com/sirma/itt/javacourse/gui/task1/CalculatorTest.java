package com.sirma.itt.javacourse.gui.task1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the calculator.
 * 
 * @author user
 */
public class CalculatorTest {
	private CommandListener listener;

	/**
	 * Set up the {@link CommandListener} before each test.
	 */
	@Before
	public void setUp() {
		listener = new CommandListener(new Calculator());
	}

	/**
	 * Test the operations of the calculator for correct result.
	 */
	@Test
	public void testOperations() {
		listener.calculate("+", 25);
		listener.calculate("+", 2);
		listener.calculate("/", 2);
		assertEquals(13.5, listener.getResult(), 0.001);
	}

	/**
	 * Testing the deletion of the last number from the input string.
	 */
	@Test
	public void testDeletion() {

		assertEquals("12098", listener.deleteLastDigit("120981"));

	}

	/**
	 * Testing the transition from a normal int to a double.
	 */
	@Test
	public void testTurnDouble() {
		assertEquals("1234.", listener.turnDouble("1234"));
	}
}
