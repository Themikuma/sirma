package com.sirma.itt.javacourse.intro;

/**
 * Class containing a method implementing the quicksort.
 * 
 * @author metodskiPC
 */
public class QuickSort {

	/**
	 * A method, sorting the inputArray with the quicksort algorithm.
	 * 
	 * @param inputArray
	 *            the input array yet to be sorted
	 * @param startIndex
	 *            the beginning index of some part of the array ( the one we are currently sorting )
	 * @param endIndex
	 *            the ending index of some part of the array ( the one we are currently sorting )
	 * @return the sorted array
	 */
	int[] quickSort(int[] inputArray, int startIndex, int endIndex) {
		int i = startIndex;
		int j = endIndex;
		int y = inputArray[i + (j - i) / 2];
		do {
			while (inputArray[i] < y)
				i++;
			while (inputArray[j] > y)
				j--;
			if (i <= j) {
				int z = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = z;
				i++;
				j--;
			}
		} while (i <= j);

		if (startIndex < j)
			quickSort(inputArray, startIndex, j);
		if (i < endIndex)
			quickSort(inputArray, i, endIndex);
		return inputArray;
	}

	/**
	 * An overload method allowing us to start the quicksort method without specifying start index
	 * and end index.
	 * 
	 * @param inputArray
	 *            the input array yet to be sorted
	 * @return the sorted array
	 */
	int[] quickSort(int[] inputArray) {
		if (inputArray.length == 0 || inputArray == null) {
			throw new IllegalArgumentException();
		}
		return quickSort(inputArray, 0, inputArray.length - 1);
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
