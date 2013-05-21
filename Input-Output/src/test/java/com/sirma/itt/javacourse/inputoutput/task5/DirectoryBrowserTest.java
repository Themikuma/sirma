package com.sirma.itt.javacourse.inputoutput.task5;

import static org.junit.Assert.assertEquals;

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
	 */
	@Test
	public void testListContent() {

		assertEquals(
				"The directory containst the following directories: src, and the following files: .classpath,.project,pom.xml,",
				DirectoryBrowser.listContent(System.getProperty("user.home")
						+ "/My Documents/maven/intro"));
		assertEquals(
				"That's a file",
				DirectoryBrowser.listContent(System.getProperty("user.home") + "/My Documents/"
						+ "hello.txt"));
	}

	/**
	 * Testing the ListContent method with a non existent file.
	 */
	@Test
	public void testListContentException() {
		Path path = Paths.get(System.getProperty("user.home"), "asd");
		assertEquals("The file does not exist", DirectoryBrowser.listContent(path.toString()));
	}
}
