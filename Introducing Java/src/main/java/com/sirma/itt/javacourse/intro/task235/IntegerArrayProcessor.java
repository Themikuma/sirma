package com.sirma.itt.javacourse.intro.task235;

/**
 * A class, containing a method that returns the smallest element of an int array, method returning
 * the sum of the elements of an int array and a method printing out each element of an int array.
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
	public boolean isArrayEmpty(int[] input) {
		if (input == null || input.length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Static method that can be accessed without instantiating the class, checking if the input
	 * array is empty or null.
	 * 
	 * @param input
	 *            the input array
	 */
	private void checkArrayEmpty(int[] input) {
		if (isArrayEmpty(input)) {
			throw new IllegalArgumentException("The input array cannot be null or empty");
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
		checkArrayEmpty(inputArray);
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
		checkArrayEmpty(inputArray);
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
		checkArrayEmpty(inputArray);
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
		checkArrayEmpty(inputArray);
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
