package com.sirma.itt.javacourse.designpatterns.task7;

/**
 * An example implementation of the Calculator with some basic operations.
 * 
 * @author user
 */
public class Calculator {

	/**
	 * Add 2 or more double values.
	 * 
	 * @param input
	 *            the string containing the values and the operation
	 * @return the result of the operation
	 */
	public String add(String input) {
		String[] elements = input.split("\\+");
		double result = Double.parseDouble(elements[0]);
		for (int i = 1; i < elements.length; i++) {
			result += Double.parseDouble(elements[i]);
		}
		return Double.toString(result);

	}

	/**
	 * Substract 2 or more double values.
	 * 
	 * @param input
	 *            the string containing the values and the operation
	 * @return the result of the operation
	 */
	public String substract(String input) {
		String[] elements = input.split("\\-");
		double result = Double.parseDouble(elements[0]);
		for (int i = 1; i < elements.length; i++) {
			result -= Double.parseDouble(elements[i]);
		}
		return Double.toString(result);
	}

	/**
	 * Divide 2 or more double values.
	 * 
	 * @param input
	 *            the string containing the values and the operation
	 * @return the result of the operation
	 */
	public String divide(String input) {
		String[] elements = input.split("/");
		double result = Double.parseDouble(elements[0]);
		for (int i = 1; i < elements.length; i++) {
			result /= Double.parseDouble(elements[i]);
		}
		return Double.toString(result);
	}

	/**
	 * Multiply 2 or more double values.
	 * 
	 * @param input
	 *            the string containing the values and the operation
	 * @return the result of the operation
	 */
	public String multiply(String input) {
		String[] elements = input.split("\\*");
		double result = Double.parseDouble(elements[0]);
		for (int i = 1; i < elements.length; i++) {
			result *= Double.parseDouble(elements[i]);
		}
		return Double.toString(result);
	}

	/**
	 * Calculate the power of 2 or more double values.
	 * 
	 * @param input
	 *            the string containing the values and the operation
	 * @return the result of the operation
	 */
	public String pow(String input) {
		String[] elements = input.split("\\^");
		double result = Double.parseDouble(elements[0]);
		for (int i = 1; i < elements.length; i++) {
			result = Math.pow(result, Double.parseDouble(elements[i]));
		}
		return Double.toString(result);
	}
}
