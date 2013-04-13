package com.sirma.itt.javacourse.intro;

/**
 * Class containing a method that returns the smallest element of an int array, method returning the
 * sum of the elements of an int array and a method printing out each element of an int array.
 * 
 * @author metodskiPC
 */
public class ArrayProcessing {

	/**
	 * A method that returns the smallest element in an array.
	 * 
	 * @param inputArray
	 *            Input array containing integers
	 * @return the smallest element in the array
	 */
	int getMinElement(int[] inputArray) {
		if (inputArray.length == 0 || inputArray == null) {
			throw new IllegalArgumentException();
		}
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
	int getSum(int[] inputArray) {
		int sum = 0;
		if (inputArray.length == 0 || inputArray == null) {
			throw new IllegalArgumentException();
		}
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
	void printElements(int[] inputArray) {
		if (inputArray.length == 0 || inputArray == null) {
			throw new IllegalArgumentException();
		}
		for (int number : inputArray) {
			System.out.print(number);
		}

	}

	/**
	 * Main method of the class.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
