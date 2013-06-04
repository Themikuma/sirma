package com.sirma.itt.javacourse.inputoutput.task5;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
	public void testListContentFile() {
		DirectoryBrowser.DirectoryInfo directory = DirectoryBrowser.listContent(System
				.getProperty("user.home") + "/My Documents/" + "hello.txt");
		assertTrue(directory.isFile());

	}

	/**
	 * Testing the listcontent method to see if it will return the correct data if we pass it a
	 * directory.
	 */
	@Test
	public void testListContentDirectory() {
		DirectoryBrowser.DirectoryInfo directory = DirectoryBrowser.listContent(System
				.getProperty("user.home") + "/My Documents/maven/intro");
		List<String> expected = new ArrayList<>();
		System.out.println(directory.getFiles());
		expected.add(".classpath");
		expected.add(".project");
		expected.add("pom.xml");
		expected.add("src");
		assertTrue(expected.equals(directory.getFiles()));
	}

	/**
	 * Testing the ListContent method with a non existent file.
	 */
	@Test
	public void testListContentException() {
		DirectoryBrowser.DirectoryInfo directory = DirectoryBrowser.listContent(System
				.getProperty("user.home") + "asd");
		assertTrue(directory.doesNotExist());
	}
}
