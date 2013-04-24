package com.sirma.itt.javacourse.intro;

/**
 * A class, containing a method that returns the smallest element of an int array, method returning
 * the sum of the elements of an int array and a method printing out each element of an int array.
 * 
 * @author metodskiPC
 */
public class IntegerArrayProcessor {

	/**
	 * Static method that can be accessed without instantiating the class, checking if the input
	 * array is empty or null.
	 * 
	 * @param input
	 *            the input array
	 * @return false if the array is not empty
	 */
	public static boolean isArrayEmpty(int[] input) {
		if (input == null) {
			throw new IllegalArgumentException("The input array cannot be null");
		} else if (input.length == 0) {
			throw new IllegalArgumentException("The input array cannot be empty");
		}
		return false;
	}

	/**
	 * A method that returns the smallest element in an array.
	 * 
	 * @param inputArray
	 *            Input array containing integers
	 * @return the smallest element in the array
	 */
	public int findMinElement(int[] inputArray) {
		isArrayEmpty(inputArray);
		int minElement = inputArray[0];
		for (int number : inputArray) {
			if (number < minElement) {
				minElement = number;
			}
		}
		return minElement;

	}

	/**
	 * Method returning the sum of all elements in an array.
	 * 
	 * @param inputArray
	 *            Input array containing integers
	 * @return the sum of all elements in the array
	 */
	public int getSum(int[] inputArray) {
		int sum = 0;
		isArrayEmpty(inputArray);
		for (int number : inputArray) {
			sum += number;
		}

		return sum;

	}

	/**
	 * Method printing out all elements of the array.
	 * 
	 * @param inputArray
	 *            Input array containing integers
	 */
	public void printElements(int[] inputArray) {
		isArrayEmpty(inputArray);
		for (int number : inputArray) {
			System.out.print(number);
		}

	}

	/**
	 * Finds an element in the array which splits the array in two parts for which the difference of
	 * the sums of both parts is the smallest possible(Center of mass/gravity).
	 * 
	 * @param inputArray
	 *            the input array
	 * @return the index of the element which is the center of mass
	 */
	public int findCenterOfMass(int[] inputArray) {
		isArrayEmpty(inputArray);
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

}
