package com.sirma.itt.javacourse.designpatterns.task7;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the Command pattern.
 * 
 * @author user
 */
public class CalculatorTest {
	private Calculator calc;
	private CommandFactory cmdFactory;
	private CommandInvoker invoker;

	/**
	 * Setting up the calculator, command factory and the invoker before each test.
	 * 
	 * @throws Exception
	 *             if something goes wrong
	 */
	@Before
	public void setUp() throws Exception {
		calc = new Calculator();
		cmdFactory = new CommandFactory();
		invoker = new CommandInvoker(cmdFactory);
	}

	/**
	 * Testing the normal flow of the command execution.
	 */
	@Test
	public void testCommandExecution() {
		assertEquals("10.0", invoker.execute("2+3+5", calc));
		assertEquals("6.0", invoker.execute("2*1*3", calc));
	}

	/**
	 * Testing the command execution with mixed operations.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCommandExecutionNumberFormat() {
		invoker.execute("2/3+5", calc);
	}

	/**
	 * Testing the command execution with a non existing command.
	 */
	@Test(expected = NullPointerException.class)
	public void testCommandExecutionNullPointer() {
		invoker.execute("2}4", calc);
	}

}
