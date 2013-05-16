package com.sirma.itt.javacourse.inputoutput.task5;

import static org.junit.Assert.assertEquals;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

/**
 * Testing the DirectoryBrowser class.
 * 
 * @author user
 */
public class DirectoryBrowserTest {

	/**
	 * Testing the ListContent method to see if it will return file if we pass it a file.
	 * 
	 * @throws NoSuchFileException
	 *             if the file is not found
	 */
	@Test
	public void testListContent() throws NoSuchFileException {

		assertEquals("directory", DirectoryBrowser.listContent(System.getProperty("user.home")));
		assertEquals(
				"file",
				DirectoryBrowser.listContent(System.getProperty("user.home") + "/My Documents/"
						+ "hello.txt"));
	}

	/**
	 * Testing the ListContent method with a non existent file.
	 * 
	 * @throws NoSuchFileException
	 *             if the file is not found
	 */
	@Test(expected = NoSuchFileException.class)
	public void testListContentException() throws NoSuchFileException {
		Path path = Paths.get(System.getProperty("user.home"), "asd");
		DirectoryBrowser.listContent(path.toString());
	}
}
