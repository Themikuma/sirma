package com.sirma.itt.javacourse.refanreg.task7;

import java.io.InputStream;
import java.util.Scanner;

/**
 * A class with a string code, containing the code that needs to be modified with regex.
 * 
 * @author user
 */
public final class TagReplacer {
	/**
	 * Private constructor, so the class cant be instantiated.
	 */
	private TagReplacer() {

	}

	/**
	 * Reading the code from the console until empty line is encountered, hide the x tags and return
	 * the result.
	 * 
	 * @param input
	 *            The input string containing the tags
	 * @return the string with hidden x tags
	 */
	public static String replaceTags(InputStream input) {
		Scanner reader = new Scanner(input);
		String code = "";
		while (reader.hasNextLine()) {
			String currentLine = reader.nextLine();
			if ("".equals(code))
				code += currentLine;
			else
				code += "\n" + currentLine;
			if ("".equals(currentLine)) {
				break;
			}
		}
		reader.close();
		return code.replaceAll("<x[^<]*[^>]/x>", "<x/>");

	}

}
