package com.sirma.itt.javacourse.inputoutput.task6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testing the saving and loading of an object from a file.
 * 
 * @author user
 */
public class DataClassTest {

	private static UserDefinedObject userObject;
	private static DataClass objectManipulator;

	/**
	 * Setting up the {@link UserDefinedObject} and {@link DataClass} for the class.
	 * 
	 * @throws Exception
	 *             if anything goes wrong in the setup
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userObject = new UserDefinedObject("Pesho");
		objectManipulator = new DataClass();
	}

	/**
	 * Creating the file before each test.
	 */
	@Before
	public void createObjectBeforeMethod() {
		objectManipulator.saveObject("resources\\userObject.usr", userObject);
	}

	/**
	 * Deleting the file after each test.
	 */
	@After
	public void deleteOBjectAfterMethod() {
		try {
			Files.delete(Paths.get("resources\\userObject.usr"));
		} catch (IOException e) {
			throw new RuntimeException("General I/O exception", e);
		}
	}

	/**
	 * Testing to see if the file has been created successfully.
	 */
	@Test
	public void testSaveObject() {

		assertTrue(Files.exists(Paths.get("resources\\userObject.usr")));

	}

	/**
	 * Testing to see if the object has been loaded successfully.
	 */
	@Test
	public void testGetObject() {

		UserDefinedObject loadedUserObject = objectManipulator
				.getObject("resources\\userObject.usr");
		assertEquals("Pesho", loadedUserObject.getName());

	}
}
