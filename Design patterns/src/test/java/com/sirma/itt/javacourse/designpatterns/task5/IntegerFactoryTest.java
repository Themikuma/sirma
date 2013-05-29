package com.sirma.itt.javacourse.designpatterns.task5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testing a class implementing the proxy pattern.
 * 
 * @author user
 */
public class IntegerFactoryTest {

	/**
	 * Testing the factory of the integer proxies.
	 */
	@Test
	public void testIntegerProxyCreation() {
		Number maskedInteger = IntegerFactory.createInstance();
		assertTrue("IntegerProxy".equals(maskedInteger.getClass().getSimpleName()));
		assertEquals(5, maskedInteger.getRealNumber());
	}
}
