package com.sirma.itt.javacourse.refanreg.task2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testing the print interfaces and print class parent methods.
 * 
 * @author user
 */
public class ReflectionClassFromNameTest {

	private static ReflectionClassFromName randomClass;

	/**
	 * Setting up the {@link ReflectionClassFromName} before the tests.
	 * 
	 * @throws ClassNotFoundException
	 *             when the class we are trying to instantiate by name does not exist
	 * @throws IllegalAccessException
	 *             when we don't have access to the class
	 * @throws InstantiationException
	 *             when the class has no means of instantiation
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		randomClass = new ReflectionClassFromName();
		randomClass.setClass("com.sirma.itt.javacourse.refanreg.task1.RandomClass");
	}

	/**
	 * Testing to see if the printClassInterfaces method prints out the correct interfaces.
	 */
	@Test
	public void testPrintClassInterfaces() {
		List<String> interfaces = randomClass.printClassInterfaces();
		assertTrue(interfaces.contains("interface java.io.Serializable"));
	}

	/**
	 * Testing to see if the printClassParrent method prints out the correct class parrent.
	 */
	@Test
	public void testPrintClassParrent() {
		assertEquals("class java.lang.Object", randomClass.printClassParrent());
	}
}
