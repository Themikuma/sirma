package com.sirma.itt.javacourse.objects;

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
	public int sum(int numOne, int numTwo) {
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
	public float sum(float numOne, float numTwo) {
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
	public int sum(String numOne, String numTwo) {
		return Integer.parseInt(numOne) + Integer.parseInt(numTwo);
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
	public BigInteger sum(BigInteger numOne, BigInteger numTwo) {
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
	public BigDecimal sum(BigDecimal numOne, BigDecimal numTwo) {
		BigDecimal sum = new BigDecimal(0);
		sum = sum.add(numOne);
		sum = sum.add(numTwo);
		return sum;
	}
}
