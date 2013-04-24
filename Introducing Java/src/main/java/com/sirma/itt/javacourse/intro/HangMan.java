package com.sirma.itt.javacourse.intro;

/**
 * Initialization class of the Hangman game.
 * 
 * @author user
 */
final class HangMan {

	/**
	 * Private constructor, preventing the instantiation of this class.
	 */
	private HangMan() {
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
