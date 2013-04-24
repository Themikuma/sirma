package com.sirma.itt.javacourse.intro;

/**
 * Class with a method, calculating the sum of two numbers.
 * 
 * @author user
 */
public class StringNumberSumator {

	/**
	 * Method that adds the leading zero's to the shorter array.
	 * 
	 * @param array
	 *            the shorter array
	 * @param longerArrayLength
	 *            the length of the longer array
	 * @return the shorter array, modified to fit the longer array's length
	 */
	public char[] modifyShorterArray(char[] array, int longerArrayLength) {
		char[] resultArray = new char[longerArrayLength];
		for (int i = longerArrayLength - 1; i >= 0; i--) {
			if (i < longerArrayLength - array.length) {
				resultArray[i] = '0';
			} else {

				resultArray[i] = array[i - (longerArrayLength - array.length)];
			}
		}
		return resultArray;
	}

	/**
	 * Method, calculating the sum of two numbers, passed as strings.
	 * 
	 * @param inputString
	 *            the first number
	 * @param inputStringTwo
	 *            the second number
	 * @return the sum of the numbers
	 */
	public String sum(String inputString, String inputStringTwo) {
		StringNumberChecker.isStringNumber(inputString);
		StringNumberChecker.isStringNumber(inputStringTwo);
		int lengthDifference = inputString.length() - inputStringTwo.length();
		char[] numOne = inputString.toCharArray();
		char[] numTwo = inputStringTwo.toCharArray();
		if (lengthDifference > 0) {
			numTwo = modifyShorterArray(numTwo, numOne.length);
		} else if (lengthDifference < 0) {
			numOne = modifyShorterArray(numOne, numTwo.length);
		}
		int length = numOne.length;
		int[] resultArray = new int[length];
		String result = "";

		for (int i = length - 1; i >= 0; i--) {
			resultArray[i] += Character.getNumericValue(numOne[i])
					+ Character.getNumericValue(numTwo[i]);
			if (i == 0 && resultArray[i] > 9) {
				resultArray[i] = resultArray[i] % 10;
				result += "1";
			} else if (resultArray[i] > 9) {
				int tempResult = resultArray[i];
				resultArray[i] = tempResult % 10;
				resultArray[i - 1] += 1;
			}
		}
		for (int num : resultArray) {
			result += num;
		}
		return result;

	}

}
