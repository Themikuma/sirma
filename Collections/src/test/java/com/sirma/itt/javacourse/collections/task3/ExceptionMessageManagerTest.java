package com.sirma.itt.javacourse.collections.task3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the ExceptionMessageManager class.
 * 
 * @author user
 */
public class ExceptionMessageManagerTest {
	private ExceptionMessageManager messageManager;

	/**
	 * Setting up the messageManager each time before a method is executed.
	 */
	@Before
	public void setup() {
		messageManager = new ExceptionMessageManager();
	}

	/**
	 * Testing to see if the exception is being added correctly to the message string and if the
	 * getMessages method is returning a list that isn't empty.
	 */
	@Test
	public void testAddExceptionMessage() {
		messageManager.addExceptionMessage("Invalid identity document number");
		messageManager.addExceptionMessageUsingCode("Invalid PC");
		messageManager.addExceptionMessage("Invalid credit card number");
		assertEquals(
				"Invalid identity document number@Invalid postal code@Invalid credit card number",
				messageManager.getMessage());
		Collection<String> messages = ExceptionMessageManager.getMessages(messageManager
				.getMessage());
		assertTrue(!messages.isEmpty());
	}

	/**
	 * Trying to add a non-existent exception.
	 */
	@Test(expected = NoSuchElementException.class)
	public void testAddExceptionMessageException() {
		messageManager.addExceptionMessage("haha");
	}
}
