package com.sirma.itt.javacourse.inputoutput.task3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing the FileReverser class.
 * 
 * @author user
 */
public class FileReverserTest {

	/**
	 * Testing the read method of the filereverser class for correct read data.
	 */
	@Test
	public void testReadFile() {
		FileReverser fileReverser = new FileReverser("hello.txt");
		String expectedData = "line1\nline2\nline3";
		assertEquals(expectedData, fileReverser.readFile().toString());

	}

	/**
	 * Testing the reverse method of the filereverser class for correct read data after file
	 * reversion.
	 */
	@Test
	public void testReverseFile() {
		FileReverser fileReverser = new FileReverser("hello.txt");
		String expectedData = "3enil\n2enil\n1enil";
		fileReverser.reverseFile();
		assertEquals(expectedData, fileReverser.readFile().toString());
		fileReverser.reverseFile();
	}

}