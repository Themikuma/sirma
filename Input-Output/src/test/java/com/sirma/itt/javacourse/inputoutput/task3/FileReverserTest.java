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
		FileReverser fileReverser = new FileReverser();
		String expectedData = "line3\nline2\nline1";
		assertEquals(expectedData, fileReverser.readFileReversed("resources\\hello.txt").toString());

	}

	/**
	 * Testing the reverse method of the filereverser class for correct read data after file
	 * reversion.
	 */
	@Test
	public void testReverseFile() {
		FileReverser fileReverser = new FileReverser();
		String expectedData = "line1\nline2\nline3";
		fileReverser.saveFileReversed("resources\\hello.txt");
		assertEquals(expectedData, fileReverser.readFileReversed("resources\\hello.txt").toString());
		fileReverser.saveFileReversed("resources\\hello.txt");
	}

}
