package com.sirma.itt.javacourse.intro;

/**
 * Initialization class of the Hangman game.
 * 
 * @author user
 */
final class HangMan {

	/**
	 * Private constructor, throwing an error, preventing anyone from instantiating this class.
	 */
	private HangMan() {
		throw new AssertionError("Can't instantiate utility class");
	}

	/**
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		HangManGame game = new HangManGame();
		game.play(new HangManManualReader());
	}
}
