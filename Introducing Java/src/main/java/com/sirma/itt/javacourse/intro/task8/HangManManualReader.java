package com.sirma.itt.javacourse.intro.task8;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * The manual reader of the Hangman game. Handles reading the initial word and the letters
 * afterwards from the user(keyboard).
 * 
 * @author user
 */
public class HangManManualReader implements HangManReader {
	/**
	 * Reads a line from the Input stream.
	 * 
	 * @return the read word.
	 */
	public String getWord() {
		java.io.InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		try {
			line = br.readLine();
		} catch (Exception e) {
		}
		return line;
	}

	/**
	 * Reads a line from the input stream. Then gets it's first letter.
	 * 
	 * @return the first letter of the read line.
	 */
	public char getLetter() {
		java.io.InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		try {
			line = br.readLine();
		} catch (Exception e) {
		}
		return line.charAt(0);
	}
}
