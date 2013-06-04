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
	}

	/**
	 * Testing to see if the printClassInterfaces method prints out the correct interfaces.
	 * 
	 * @throws ClassNotFoundException
	 *             if the class is not found
	 */
	@Test
	public void testPrintClassInterfaces() throws ClassNotFoundException {
		List<String> interfaces = randomClass
				.printClassInterfaces("com.sirma.itt.javacourse.refanreg.task1.RandomClass");
		assertTrue(interfaces.contains("interface java.io.Serializable"));
	}

	/**
	 * Testing to see if the printClassParrent method prints out the correct class parrent.
	 * 
	 * @throws ClassNotFoundException
	 *             if the class is not found
	 */
	@Test
	public void testPrintClassParrent() throws ClassNotFoundException {
		assertEquals("class java.lang.Object",
				randomClass
						.printClassParrent("com.sirma.itt.javacourse.refanreg.task1.RandomClass"));
	}
}
