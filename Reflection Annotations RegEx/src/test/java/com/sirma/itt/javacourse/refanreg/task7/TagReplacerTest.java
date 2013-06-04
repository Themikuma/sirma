package com.sirma.itt.javacourse.refanreg.task7;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

/**
 * Test class, testing the TagReplacer class.
 * 
 * @author user
 */
public class TagReplacerTest {
	private static final String CODE_FULL;
	private static final String CODE_HIDDEN;

	static {
		CODE_FULL = "<x><b></b><x>Hello world</x>" + "<b>sdfsdf</b><x>Good"
				+ "morning</x><x>69</x><x>sdfsdfsdf</x>" + "</x>";
		CODE_HIDDEN = "<x><b></b><x/>" + "<b>sdfsdf</b><x/><x/><x/>" + "</x>";

	}

	/**
	 * Testing the replaceTags method of the class to see if it modifies the input string
	 * accordingly.
	 */
	@Test
	public void testReplaceTags() {
		InputStream input = new ByteArrayInputStream(CODE_FULL.getBytes());
		assertEquals(CODE_HIDDEN, TagReplacer.replaceTags(input));
	}
}
