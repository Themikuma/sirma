package com.sirma.itt.javacourse.exceptions.task1;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Class with overloading methods, accepting ints, floats, strings, bigintegers and bigdecimals.
 * 
 * @author user
 */
public class Sumator {

	/**
	 * Calculates the sum of 2 numbers if they are integers.
	 * 
	 * @param numOne
	 *            the first number
	 * @param numTwo
	 *            the second number
	 * @return the sum
	 */
	public int calculateSum(int numOne, int numTwo) {
		return numOne + numTwo;
	}

	/**
	 * Calculates the sum of 2 numbers if they are floats.
	 * 
	 * @param numOne
	 *            the first number
	 * @param numTwo
	 *            the second number
	 * @return the sum
	 */
	public float calculateSum(float numOne, float numTwo) {
		return numOne + numTwo;
	}

	/**
	 * Calculates the sum of 2 numbers if they are strings.
	 * 
	 * @param numOne
	 *            the first number
	 * @param numTwo
	 *            the second number
	 * @return the sum
	 */
	public String calculateSum(String numOne, String numTwo) {
		int firstNumber = 0;
		int secondNumber = 0;

		try {
			firstNumber = Integer.parseInt(numOne);
			secondNumber = Integer.parseInt(numTwo);
		} catch (NumberFormatException e) {
			System.out.println("The input must contain only numbers");
			throw e;
		}
		return Integer.toString(firstNumber + secondNumber);
	}

	/**
	 * Calculates the sum of 2 numbers if they are BigIntegers.
	 * 
	 * @param numOne
	 *            the first number
	 * @param numTwo
	 *            the second number
	 * @return the sum
	 */
	public BigInteger calculateSum(BigInteger numOne, BigInteger numTwo) {
		BigInteger sum = new BigInteger("0");
		sum.add(numOne);
		sum.add(numTwo);
		return sum;
	}

	/**
	 * Calculates the sum of 2 numbers if they are BigDecmals.
	 * 
	 * @param numOne
	 *            the first number
	 * @param numTwo
	 *            the second number
	 * @return the sum
	 */
	public BigDecimal calculateSum(BigDecimal numOne, BigDecimal numTwo) {
		BigDecimal sum = new BigDecimal(0);
		sum = sum.add(numOne);
		sum = sum.add(numTwo);
		return sum;
	}
}
