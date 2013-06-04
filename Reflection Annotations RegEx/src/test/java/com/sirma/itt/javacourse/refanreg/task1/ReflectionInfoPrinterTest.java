package com.sirma.itt.javacourse.refanreg.task1;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testing the printing of methods and fields of a class.
 * 
 * @author user
 */
public class ReflectionInfoPrinterTest {
	private static ReflectionInfoPrinter randomClass;

	/**
	 * Setting up the custom class before the tests.
	 * 
	 * @throws Exception
	 *             if something goes wrong with the setup
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		randomClass = new ReflectionInfoPrinter();
	}

	/**
	 * Testing the printClassMethods method to see if it returns a list of the custom class's
	 * methods.
	 */
	@Test
	public void testPrintClassMethods() {
		List<String> classMethods = randomClass.printClassMethods(new RandomClass());
		assertTrue(classMethods
				.contains("private void com.sirma.itt.javacourse.refanreg.task1.RandomClass.privateMethod()"));

	}

	/**
	 * Testing the printClassFields method to see if it returns a list of the custom class's fields.
	 */
	@Test
	public void testPrintClassFields() {
		List<String> classFields = randomClass.printClassFields(new RandomClass());
		assertTrue(classFields
				.contains("public java.lang.String com.sirma.itt.javacourse.refanreg.task1.RandomClass.publicString"));
	}

}
