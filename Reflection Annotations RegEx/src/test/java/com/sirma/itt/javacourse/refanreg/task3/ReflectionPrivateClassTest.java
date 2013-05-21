package com.sirma.itt.javacourse.refanreg.task3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the {@link ReflectionPrivateClass}.
 * 
 * @author user
 */
public class ReflectionPrivateClassTest {
	private ReflectionPrivateClass privateClassReflector;

	/**
	 * Setting up the class and the name of the fields and methods that are going to be used from
	 * the class before each test.
	 * 
	 * @throws Exception
	 *             if something goes wrong
	 */
	@Before
	public void setUpBeforeClass() throws Exception {
		privateClassReflector = new ReflectionPrivateClass(new PrivateClass());
		privateClassReflector.setFieldFromName("changeMe");
		privateClassReflector.setMethodFromName("callMe");
	}

	/**
	 * Testing to see if the access of the field is being set correctly.
	 */
	@Test
	public void testChangeFieldAccess() {
		privateClassReflector.changeFieldAccess();
		assertTrue(privateClassReflector.getPrivateField().isAccessible());
		privateClassReflector.changeFieldAccess();
		assertFalse(privateClassReflector.getPrivateField().isAccessible());
	}

	/**
	 * Testing to see if the access of the method is being set correctly.
	 */
	@Test
	public void testChangeMethodAccess() {
		privateClassReflector.changeMethodAccess();
		assertTrue(privateClassReflector.getPrivateMethod().isAccessible());
		privateClassReflector.changeMethodAccess();
		assertFalse(privateClassReflector.getPrivateMethod().isAccessible());
	}

	/**
	 * Trying to invoke a private method from a class and seeing if the returned result is the
	 * expected one.
	 */
	@Test
	public void testInvokePrivateClassMethod() {
		privateClassReflector.changeMethodAccess();
		String result = privateClassReflector.invokePrivateClassMethod();
		assertEquals("I have been summoned!", result);
	}

}
