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
public class RandomClassUserByNameTest {

	private static RandomClassUserByName randomClass;

	/**
	 * Setting up the {@link RandomClassUserByName} before the tests.
	 * 
	 * @throws Exception
	 *             if something goes wrong with the setup
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		randomClass = new RandomClassUserByName(
				"com.sirma.itt.javacourse.refanreg.task1.RandomClass");
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
