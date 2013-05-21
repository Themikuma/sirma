package com.sirma.itt.javacourse.refanreg.task4;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;



/**
 * Test class testing the SortNumberedClasses class.
 * 
 * @author user
 */
public class SortNumberedClassesTest {

	/**
	 * Testing the sortArray method of the SortNumberedClasses class.
	 */
	@Test
	public void testSortArray() {
		ChildClassOne firstChild = new ChildClassOne();
		ChildClassTwo secondChild = new ChildClassTwo();
		ChildClassThree thirdChild = new ChildClassThree();
		ParentClass[] inputArray = NumberedSorter.sortArray(new ParentClass[] { thirdChild,
				firstChild, secondChild });
		ParentClass[] resultArray = { firstChild, secondChild, thirdChild };
		assertTrue(Arrays.equals(inputArray, resultArray));
	}
}
