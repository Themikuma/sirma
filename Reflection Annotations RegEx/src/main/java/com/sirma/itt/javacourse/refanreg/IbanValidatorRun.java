package com.sirma.itt.javacourse.refanreg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IbanValidatorRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IbanValidator validator = new IbanValidator();
		java.io.InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String result = "";
		String line = null;
		try {
			while (!(line = br.readLine()).equals("</bankAccounts>")) {
				result += line + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(validator.hideIban(result));

	}
}
