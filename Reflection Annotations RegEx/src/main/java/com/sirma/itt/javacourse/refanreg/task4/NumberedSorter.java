package com.sirma.itt.javacourse.refanreg.task4;

import java.util.Arrays;

/**
 * A class with an array of Classes to be sorted.
 * 
 * @author user
 */
public final class NumberedSorter {
	/**
	 * A private constructor, overriding the default one, so the class can't be initialized.
	 */
	private NumberedSorter() {

	}

	/**
	 * Sorting the class array with Arrays.sort and printing it out.
	 * 
	 * @param classArray
	 *            the input array to be sorted
	 * @return the sorted array
	 */
	public static ParentClass[] sortArray(ParentClass[] classArray) {
		Arrays.sort(classArray);
		return classArray;
	}
}
