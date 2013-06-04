package com.sirma.itt.javacourse.refanreg.task6;

import java.io.InputStream;
import java.util.Scanner;

/**
 * A class with a string field containing ibans, a method that reads text from the console and a
 * method that hides BG ibans with regex.
 * 
 * @author user
 */
public final class IbanValidator {
	/**
	 * Private constructor, so the class cant be instantiated.
	 */
	private IbanValidator() {

	}

	/**
	 * Reading the ibans from the console until /bankAccounts is encountered, hide them and return
	 * the result.
	 * 
	 * @param input
	 *            The input string containing the ibans
	 * @return the string with hidden ibans
	 */
	public static String hideIbans(InputStream input) {
		Scanner reader = new Scanner(input);
		String ibans = "";
		while (reader.hasNextLine()) {
			String currentLine = reader.nextLine();
			if ("".equals(ibans))
				ibans += currentLine;
			else
				ibans += "\n" + currentLine;
			if ("</bankAccounts>".equals(currentLine)) {
				break;
			}
		}
		reader.close();
		return ibans.replaceAll("BG80 BNBG( \\d{4}){3}(?=( \\d{4}){1}<\\/iban>)", "****");
	}
}
