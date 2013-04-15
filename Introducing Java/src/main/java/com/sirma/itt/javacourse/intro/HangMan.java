package com.sirma.itt.javacourse.intro;

/**
 * Initialization class of the Hangman game.
 * 
 * @author user
 */
public class HangMan {

	/**
	 * Initialization method.
	 */
	public void initGame() {
		HangManGame game = new HangManGame();
		game.play(new HangManManualReader());
	}

	/**
	 * 
	 */
	HangMan() {
		initGame();
	}

	/**
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		HangMan game = new HangMan();
	}
}
