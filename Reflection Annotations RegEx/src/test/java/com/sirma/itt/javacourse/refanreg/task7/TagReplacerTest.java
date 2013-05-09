package com.sirma.itt.javacourse.refanreg.task7;

import static org.junit.Assert.assertEquals;

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
	 * Testing the input method of the class for correct data.
	 */
	@Test
	public void testReadCode() {
		TagReplacer tagReplacer = new TagReplacer();
		tagReplacer.readCode(CODE_FULL);
		assertEquals(CODE_FULL, tagReplacer.getCode());
	}

	/**
	 * Testing the replaceTags method of the class to see if it modifies the input string
	 * accordingly.
	 */
	@Test
	public void testReplaceTags() {
		TagReplacer tagReplacer = new TagReplacer();
		tagReplacer.readCode(CODE_FULL);
		String result = tagReplacer.replaceTags();
		assertEquals(CODE_HIDDEN, result);
	}
}
