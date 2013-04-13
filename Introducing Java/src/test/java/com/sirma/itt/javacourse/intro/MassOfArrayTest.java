package com.sirma.itt.javacourse.intro;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class, testing the methods from the class MassOfArray.
 * 
 * @author metodskiPC
 */
public class MassOfArrayTest {

	/**
	 * Testing the centerOfMass method.
	 */
	@Test
	public void testCenterOfMass() {
		MassOfArray massClass = new MassOfArray();
		assertEquals(4, massClass.centerOfMass(new int[] { 1, 2, 3, 4, 5 }));
		assertEquals(4, massClass.centerOfMass(new int[] { 1, 1, 1, 100, 1, 1 }));
		assertEquals(2, massClass.centerOfMass(new int[] { 0, 5, 0 }));
		assertEquals(4, massClass.centerOfMass(new int[] { 100, 0, 0, 300 }));
		assertEquals(3, massClass.centerOfMass(new int[] { 1, 1, 1, 1 }));
	}

	/**
	 * Method, testing the method centerOfMass from the MassOfArray class for exceptions.
	 */
	@Test(expected = IllegalArgumentException.class)
<<<<<<< HEAD
	public void testCenterOfMassException() {
=======
	public void testGetMinElementException() {
>>>>>>> a9269f93848d4e6c3b06eb0147651528b5270a96
		MassOfArray massClass = new MassOfArray();
		assertEquals("Can't handle null arrays", massClass.centerOfMass(new int[] {}));
		assertEquals("Can't handle null arrays", massClass.centerOfMass(null));
	}
}
