package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberAdditionTest {

	@Test
	public void testSum() {
		NumberAddition addClass = new NumberAddition();
		assertEquals(1011, addClass.sum("911", "100"));
		assertEquals(2, addClass.sum("1", "1"));
		assertEquals(1998, addClass.sum("999", "999"));
		assertEquals(9968, addClass.sum("9753", "215"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSumException() {
		NumberAddition addClass = new NumberAddition();
		addClass.sum("a21", "211");
		addClass.sum(null, "211");
		addClass.sum("", "211");
	}

}
