package com.sirma.itt.javacourse.intro;

/**
 * Class with a method, calculating the sum of two numbers.
 * 
 * @author user
 */
public class NumberAddition {
	/**
	 * Method, calculating the sum of two numbers, passed as strings.
	 * 
	 * @param numberOne
	 *            the first number
	 * @param numberTwo
	 *            the second number
	 * @return the sum of the numbers
	 */
	public int sum(String numberOne, String numberTwo) {
		if (!numberOne.matches("[0-9]+") || !numberTwo.matches("[0-9]+") || numberOne == null
				|| numberTwo == null || "".equals(numberOne) || "".equals(numberTwo)) {
			throw new IllegalArgumentException();
		}
		char[] numOne = numberOne.toCharArray();
		char[] numTwo = numberTwo.toCharArray();
		int[] resultArray;
		int lengthOne = numOne.length;
		int lengthTwo = numTwo.length;
		String result = "";

		if (lengthOne > lengthTwo) {
			resultArray = new int[lengthOne];
			for (int i = lengthOne - 1; i >= 0; i--) {
				if (i < lengthOne - lengthTwo) {
					resultArray[i] += Character.getNumericValue(numOne[i]);
					if (i == 0 && resultArray[i] > 9) {
						resultArray[i] = resultArray[i] % 10;
						result += "1";
					}
				} else {
					resultArray[i] += Character.getNumericValue(numOne[i])
							+ Character.getNumericValue(numTwo[i - (lengthOne - lengthTwo)]);
				}
				if (resultArray[i] > 9) {
					int tempResult = resultArray[i];
					resultArray[i] = tempResult % 10;
					resultArray[i - 1] += 1;
				}
			}
		} else if (lengthTwo > lengthOne) {
			resultArray = new int[lengthTwo];
			for (int i = lengthTwo - 1; i >= 0; i--) {
				if (i < lengthTwo - lengthOne) {
					resultArray[i] += Character.getNumericValue(numTwo[i]);
					if (i == 0 && resultArray[i] > 9) {
						resultArray[i] = resultArray[i] % 10;
						result += "1";
					}
				} else {
					resultArray[i] += Character.getNumericValue(numTwo[i])
							+ Character.getNumericValue(numOne[i - (lengthTwo - lengthOne)]);
				}
				if (resultArray[i] > 9) {
					int tempResult = resultArray[i];
					resultArray[i] = tempResult % 10;
					resultArray[i - 1] += 1;
				}
			}
		}

		else {
			resultArray = new int[lengthTwo];
			for (int i = lengthTwo - 1; i >= 0; i--) {
				resultArray[i] += Character.getNumericValue(numTwo[i])
						+ Character.getNumericValue(numOne[i - (lengthTwo - lengthOne)]);
				if (i == 0 && resultArray[i] > 9) {
					resultArray[i] = resultArray[i] % 10;
					result += "1";
				}
				if (resultArray[i] > 9) {
					int tempResult = resultArray[i];
					resultArray[i] = tempResult % 10;
					resultArray[i - 1] += 1;
				}

			}

		}
		for (int num : resultArray) {
			result += num;
		}
		return Integer.parseInt(result);
	}
}
