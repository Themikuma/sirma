package com.sirma.itt.javacourse.inputoutput.task4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

/**
 * Test class, testing the TransferObject class.
 * 
 * @author user
 */
public class TransferObjectTest {

	/**
	 * Initializing a TransferObject class and testing its transfer method.
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testTransfer() throws FileNotFoundException {
		File file = new File("C:\\Users\\user\\Downloads\\eclipse-SDK-4.2.2-win32-x86_64.zip");
		TransferObject transferClass = new TransferObject(new FileInputStream(file),
				new FileOutputStream(
						"C:\\Users\\user\\Downloads\\eclipse-SDK-4.2.2-win32-x86_64_2.zip"));
		transferClass.transfer((int) file.length(), 0);
		// assertEquals(2, transferClass.transfer(2, 1));
		// assertEquals(3, transferClass.transfer(5, 1));
	}
}
