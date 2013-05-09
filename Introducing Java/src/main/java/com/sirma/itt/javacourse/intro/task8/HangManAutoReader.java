package com.sirma.itt.javacourse.intro.task8;


/**
 * The automatic reader of the Hangman game. Passes already set word & letters to the hangman game
 * instead user input.
 * 
 * @author user
 */
public class HangManAutoReader implements HangManReader {
	private String word;
	private char[] guesses;
	private int guessIndex = 0;

	/**
	 * Constructor, setting the input word and guesses instead of using user input. Used for
	 * testing.
	 * 
	 * @param word
	 *            the word to be guessed
	 * @param guesses
	 *            the letters to be passed to the hangman game
	 */
	public HangManAutoReader(String word, char[] guesses) {
		this.word = word;
		this.guesses = guesses;
	}

	/**
	 * Reads a line from the Input stream.
	 * 
	 * @return the read word.
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Reads a line from the input stream. Then gets it's first letter.
	 * 
	 * @return the first letter of the read line.
	 */
	public char getLetter() {
		return guesses[guessIndex++];
	}
}
