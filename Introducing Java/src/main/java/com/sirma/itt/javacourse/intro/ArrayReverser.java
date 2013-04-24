package com.sirma.itt.javacourse.intro;

/**
 * Class with e method, reversing an array.
 * 
 * @author user
 */
public class ArrayReverser {
	/**
	 * Method which reverses an array without using a second one.
	 * 
	 * @param inputArray
	 *            an input array yet to be reversed
	 * @return the reversed array
	 */
	public int[] reverseArray(int[] inputArray) {
		if (inputArray.length == 0 || inputArray == null) {
			throw new IllegalArgumentException();
		}
		int inputLength = inputArray.length;
		int end = inputLength - 1;
		for (int i = 0; i < inputLength / 2; i++) {
			int z = inputArray[i];
			inputArray[i] = inputArray[end - i];
			inputArray[end - i] = z;
		}
		return inputArray;
	}
}
