package com.sirma.itt.javacourse.inputoutput.task5;

import static org.junit.Assert.assertEquals;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class DirectoryBrowserTest {

	@Test
	public void testListContent() throws NoSuchFileException {

		assertEquals("directory", DirectoryBrowser.listContent(System.getProperty("user.home")));
		assertEquals(
				"file",
				DirectoryBrowser.listContent(System.getProperty("user.home") + "/My Documents/"
						+ "hello.txt"));
	}

	@Test(expected = NoSuchFileException.class)
	public void testListContentException() throws NoSuchFileException {
		Path path = Paths.get(System.getProperty("user.home"), "asd");
		DirectoryBrowser.listContent(path.toString());
	}
}
