package com.sirma.itt.javacourse.intro.task235;

/**
 * A class, containing a method that returns the smallest element of an integer array, method
 * returning the sum of the elements of an integer array and a method printing out each element of
 * an integer array.
 * 
 * @author metodskiPC
 */
public class IntegerArrayProcessor {

	/**
	 * A public method that checks if the given array is empty.
	 * 
	 * @param input
	 *            the input array
	 * @return true if it's empty, false if it's not
	 */
	public static boolean isArrayEmpty(int[] input) {
		return (input.length == 0) ? true : false;
	}

	/**
	 * A public method that checks if the given array is null.
	 * 
	 * @param input
	 *            the input array
	 * @return true if it's null, false if it's not
	 */
	public static boolean isArrayNull(int[] input) {
		return (input == null) ? true : false;
	}

	/**
	 * A private method used only in this class, throwing appropriate exceptions.
	 * 
	 * @param input
	 *            the input array
	 */
	private void checkArrayEmptyOrNull(int[] input) {
		if (isArrayEmpty(input)) {
			throw new IllegalArgumentException("The input array cannot be empty");
		}
		if (isArrayNull(input)) {
			throw new NullPointerException("The input array cannot be null");
		}
	}

	/**
	 * A method that returns the smallest element in an array.
	 * 
	 * @param inputArray
	 *            Input array containing integers
	 * @return the smallest element in the array
	 */
	public int findMinElement(int[] inputArray) {
		checkArrayEmptyOrNull(inputArray);
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
		checkArrayEmptyOrNull(inputArray);
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
		checkArrayEmptyOrNull(inputArray);
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
		checkArrayEmptyOrNull(inputArray);
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
	 * Method which reverses an array without using a second one.
	 * 
	 * @param inputArray
	 *            an input array yet to be reversed
	 * @return the reversed array
	 */
	public int[] reverseArray(int[] inputArray) {
		checkArrayEmptyOrNull(inputArray);
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
