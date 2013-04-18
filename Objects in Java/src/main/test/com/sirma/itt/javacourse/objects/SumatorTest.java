package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Tests the methods of the class Sumator.
 * 
 * @author user
 */
public class SumatorTest {
	/**
	 * Tests the method sum of the class Sumator with different data
	 * types(int,float,string,biginteger,bigdecimal).
	 */
	@Test
	public void testSumator() {
		Sumator sumClass = new Sumator();
		assertEquals(20, sumClass.sum(10, 10));
		assertEquals(20f, sumClass.sum(10f, 10f), 0.0001);
		assertEquals(20, sumClass.sum("10", "10"));
		assertEquals(20, sumClass.sum(10, 10));
		assertEquals(new BigDecimal(20), sumClass.sum(new BigDecimal(10.0), new BigDecimal(10.0)));
	}
}
