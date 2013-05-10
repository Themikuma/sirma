package com.sirma.itt.javacourse.inputoutput.task4;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Test;

/**
 * Test class, testing the TransferObject class.
 * 
 * @author user
 */
public class TransferObjectTest {

	/**
	 * Initializing a TransferObject class and testing its transfer method.
	 */
	@Test
	public void testTransfer() {
		ByteArrayInputStream input = new ByteArrayInputStream("message".getBytes());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		TransferObject transferClass = new TransferObject(input, output);
		assertEquals(2, transferClass.transfer(2, 1));
		assertEquals(3, transferClass.transfer(5, 1));
	}

}
