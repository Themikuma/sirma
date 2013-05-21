package com.sirma.itt.javacourse.intro.task8;

/**
 * Main class of the hangman game. Holds the logic of the game like writing the initial word and
 * handling the guessed letters.
 * 
 * @author user
 */
public class HangManGame {
	private HangManReader reader;
	private int leftGuesses;
	private String word;
	private StringBuilder wordBuilder;

	/**
	 * * The start of the game. The user inputs the initial word and the method creates a new
	 * StringBuilder the same length of the word.
	 * 
	 * @param reader
	 *            The reader that is going to be used.
	 */
	private void start(HangManReader reader) {
		leftGuesses = 9;
		wordBuilder = new StringBuilder();
		System.out.println("The game is starting, please choose your word: ");
		word = reader.getWord();
		if (wordBuilder.length() > 2)
			System.out.println("Now try to guess your word. Enter a letter: ");
		for (int i = 0; i < word.length(); i++) {
			wordBuilder.append("_");
		}
	}

	/**
	 * * The play method of the game. Handles all letter guesses until the left guesses reach 0 or
	 * until the word is guessed.
	 * 
	 * @param reader
	 *            The reader that is going to be used. It can be either a manual one or an automatic
	 *            one.
	 * @return true if the game is won, false if the game is lost.
	 */
	public boolean play(HangManReader reader) {
		this.reader = reader;
		start(reader);
		while (leftGuesses != 0 && !word.equals(wordBuilder.toString())) {
			System.out.println("Please choose a letter");
			char letter = reader.getLetter();
			int position = word.indexOf(letter);
			if (position == -1) {
				leftGuesses--;
				System.out.println("Wrong guess ! Left tries: " + leftGuesses);
			}
			while (position != -1) {
				wordBuilder.setCharAt(position, letter);
				position = word.indexOf(letter, position + 1);
			}
			System.out.println(wordBuilder);
		}
		if (word.equals(wordBuilder.toString())) {
			System.out.println("Success ! You guessed the word correctly!");
			end();
			return true;
		} else {
			System.out.println("Fail ! You did not guess the word !");
			end();
			return false;
		}
	}

	/**
	 * The end of the game. Asks the user if he wants to play the game again.
	 */
	private void end() {
		wordBuilder = null;
		word = null;
		System.out.println("Do you want to play again? y/n");
		String answer = reader.getWord();
		if ("y".equals(answer)) {
			play(reader);
		} else if ("n".equals(answer)) {
		}
	}
}
