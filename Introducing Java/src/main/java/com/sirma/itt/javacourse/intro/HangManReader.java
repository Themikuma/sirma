package com.sirma.itt.javacourse.intro;

/**
 * The interface of the Hangman reader.
 * 
 * @author user
 */
public abstract class HangManReader {
	/**
	 * Reads a line from the Input stream.
	 * 
	 * @return the read word.
	 */
	public abstract String getWord();

	/**
	 * Reads a line from the input stream. Then gets it's first letter.
	 * 
	 * @return the first letter of the read line.
	 */
	public abstract char getLetter();
}
