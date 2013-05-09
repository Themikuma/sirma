package com.sirma.itt.javacourse.intro.task8;

/**
 * The interface of the Hangman reader.
 * 
 * @author user
 */
public interface HangManReader {
	/**
	 * Reads a line from the Input stream.
	 * 
	 * @return the read word.
	 */
	String getWord();

	/**
	 * Reads a line from the input stream. Then gets it's first letter.
	 * 
	 * @return the first letter of the read line.
	 */
	char getLetter();
}
