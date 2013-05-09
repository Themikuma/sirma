package com.sirma.itt.javacourse.refanreg.task6;

import java.util.Scanner;

/**
 * A class with a string field containing ibans, a method that reads text from the console and a
 * method that hides BG ibans with regex.
 * 
 * @author user
 */
public class IbanValidator {

	private String ibans;

	/**
	 * Constructor, intializing the ibans String.
	 */
	public IbanValidator() {
		ibans = "";
	}

	/**
	 * Reading the ibans from the console until /bankAccounts is encountered.
	 */
	public void readIbans() {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextLine()) {
			String currentLine = reader.nextLine();
			ibans += currentLine + "\n";
			if ("</bankAccounts>".equals(currentLine)) {
				break;
			}
		}
		reader.close();

	}

	/**
	 * An overload method for testing purposes, taking string instead of reading from the console.
	 * 
	 * @param input
	 *            the input string
	 */
	public void readIbans(String input) {
		ibans = input;
	}

	/**
	 * Replaces the first characters from the BG ibans with * via regex.
	 * 
	 * @return the input string, modified with hidden ibans
	 */
	public String hideIban() {
		String newIban = ibans.replaceAll("BG80 BNBG( \\d{4}){3}(?=( \\d{4}){1}<\\/iban>)", "****");
		return newIban;
	}

	/**
	 * Getter method for ibans.
	 * 
	 * @return the ibans
	 */
	public String getIbans() {
		return ibans;
	}

	/**
	 * Setter method for ibans.
	 * 
	 * @param ibans
	 *            the ibans to set
	 */
	public void setIbans(String ibans) {
		this.ibans = ibans;
	}
}
