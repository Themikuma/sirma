package com.sirma.itt.javacourse.intro;

/**
 * Class containing a method calculating the greatest common divisor of two numbers and a method
 * calculating the least common multiple.
 * 
 * @author metodskiPC
 */
public class Gcd {

	/**
	 * Calculates the greatest common divisor of two numbers.
	 * 
	 * @param firstNum
	 *            the first number
	 * @param secondNum
	 *            the second number
	 * @return the greatest common divisor of the numbers
	 */
	public int gcd(int firstNum, int secondNum) {
		if (firstNum == secondNum)
			return firstNum;
		else if (firstNum > secondNum)
			return gcd(firstNum - secondNum, secondNum);
		else
			return gcd(firstNum, secondNum - firstNum);
	}

	/**
	 * Calculates the least common multiple of two numbers.
	 * 
	 * @param firstNum
	 *            the first number
	 * @param secondNum
	 *            the second number
	 * @return the least common multiple of two numbers
	 */
	public int lcm(int firstNum, int secondNum) {
		return firstNum * secondNum / gcd(firstNum, secondNum);
	}

}