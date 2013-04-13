package com.sirma.itt.javacourse.intro;

/**
 * A class, containing a method returning the center of mass for a given array.
 * 
 * @author metodskiPC
 */
public class MassOfArray {

	/**
	 * Finds an element in the array which splits the array in two parts for which the difference of
	 * the sums of both parts is the smallest possible(Center of mass/gravity).
	 * 
	 * @param inputArray
	 *            the input array
	 * @return the index of the element which is the center of mass
	 */
	int centerOfMass(int[] inputArray) {
		if (inputArray.length == 0 || inputArray == null) {
			throw new IllegalArgumentException();
		}
		int arraySum = 0;
		for (int a : inputArray) {
			arraySum += a;
		}
		int halfSum = arraySum / 2;
		arraySum = 0;
		for (int i = 0, n = inputArray.length; i < n; i++) {
			arraySum += inputArray[i];
			if (arraySum > halfSum) {
				return i + 1;
			}
		}
		return 0;
	}

	/**
	 * Main method of the class.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {

	}

}
