package com.sirma.itt.javacourse.intro;

/**
 * Class with a method calculating the greatest common divisor of two numbers.
 * 
 * @author metodskiPC
 */
public class Gcd {

	/**
	 * Calculates the greatest common divisor of two numbers.
	 * 
	 * @param a
	 *            the first number
	 * @param b
	 *            the second number
	 * @return the greatest common divisor of the numbers
	 */
	int gcd(int a, int b) {
		int firstNum = a;
		int secondNum = b;
		if (firstNum == secondNum)
			return firstNum;
		else if (firstNum > secondNum)
			firstNum -= secondNum;
		else
			secondNum -= firstNum;
		return gcd(firstNum, secondNum);
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