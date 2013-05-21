package com.sirma.itt.javacourse.intro.task4;

import com.sirma.itt.javacourse.intro.task235.IntegerArrayProcessor;

/**
 * Class containing a method implementing the quick sort algorithm.
 * 
 * @author metodskiPC
 */
public class QuickSort {

	/**
	 * A method, sorting the inputArray with the quick sort algorithm.
	 * 
	 * @param inputArray
	 *            the input array yet to be sorted
	 * @param startIndex
	 *            the beginning index of some part of the array ( the one we are currently sorting )
	 * @param endIndex
	 *            the ending index of some part of the array ( the one we are currently sorting )
	 * @return the sorted array
	 */
	private int[] quickSort(int[] inputArray, int startIndex, int endIndex) {
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
	 * An overload method allowing us to start the quick sort method without specifying start index
	 * and end index.
	 * 
	 * @param inputArray
	 *            the input array yet to be sorted
	 * @return the sorted array
	 */
	public int[] quickSort(int[] inputArray) {
		if (IntegerArrayProcessor.isArrayEmpty(inputArray)) {
			throw new IllegalArgumentException("input array is empty");
		}
		if (IntegerArrayProcessor.isArrayNull(inputArray)) {
			throw new NullPointerException("input array is null");
		}
		return quickSort(inputArray, 0, inputArray.length - 1);
	}
}
