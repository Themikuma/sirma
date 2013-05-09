package com.sirma.itt.javacourse.exceptions.task3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class, testing the possible outcomes from the ObjectArray class's methods.
 * 
 * @author user
 */
public class ObjectArrayTest {

	/**
	 * Test to see if the array is initalized with the correct length.
	 */
	@Test
	public void testArrayInitLength() {
		ObjectArray objectArray = new ObjectArray(5);
		assertEquals(5, objectArray.getObjectArray().length);
	}

	/**
	 * Test to see if objects are added correctly.
	 */
	@Test
	public void testArrayAddElement() {
		ObjectArray objectArray = new ObjectArray(5);
		objectArray.add(1);
		assertEquals(1, objectArray.getObjectArray()[0]);
	}

	/**
	 * Test to see if objects are remove correctly.
	 */
	@Test
	public void testArrayRemoveElement() {
		ObjectArray objectArray = new ObjectArray(5);
		objectArray.add(1);
		objectArray.add(2);
		objectArray.remove();
		objectArray.remove();
		assertEquals(null, objectArray.getObjectArray()[1]);
		assertEquals(null, objectArray.getObjectArray()[0]);
	}

	/**
	 * Test the add method for full array exception.
	 */
	@Test(expected = FullArrayException.class)
	public void testArrayAddElementException() {
		ObjectArray objectArray = new ObjectArray(5);
		objectArray.add(0);
		objectArray.add(1);
		objectArray.add(2);
		objectArray.add(3);
		objectArray.add(4);
		objectArray.remove();
		objectArray.add(4);
		objectArray.add(5);
	}

	/**
	 * Test the add method for empty array exception.
	 */
	@Test(expected = EmptyArrayException.class)
	public void testArrayRemoveElementException() {
		ObjectArray objectArray = new ObjectArray(5);
		objectArray.add(0);
		objectArray.add(1);
		objectArray.remove();
		objectArray.remove();
		objectArray.remove();
	}
}
