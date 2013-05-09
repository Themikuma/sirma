package com.sirma.itt.javacourse.refanreg.task7;

import java.util.Scanner;

/**
 * A class with a string code, containing the code that needs to be modified with regex.
 * 
 * @author user
 */
public class TagReplacer {
	private String code;

	/**
	 * Initializing the code String.
	 */
	public TagReplacer() {
		code = "";
	}

	/**
	 * Reading the code from the console until empty line is encountered.
	 */
	public void readCode() {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextLine()) {
			String currentLine = reader.nextLine();
			code += currentLine + "\n";
			if ("".equals(currentLine)) {
				break;
			}
		}
		reader.close();

	}

	/**
	 * Overload method for testing purposes, reading the code as a string instead from user input.
	 * 
	 * @param inputString
	 *            the input String
	 */
	public void readCode(String inputString) {
		code = inputString;

	}

	/**
	 * Removing data between x tags with regex.
	 * 
	 * @return the modified string
	 */
	public String replaceTags() {
		String result = code.replaceAll("<x[^<]*[^>]/x>", "<x/>");
		return result;
	}

	/**
	 * Getter method for code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter method for code.
	 * 
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
