package com.sirma.itt.javacourse.intro.task8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Class, testing the hangman game.
 * 
 * @author user
 */
public class HangManGameTest {
	/**
	 * Testing the game by using an automated reader that passes an already set word and guesses
	 * instead of user input. The first test returns true and the other one returns false.
	 */
	@Test
	public void testHangManGame() {
		HangManGame game = new HangManGame();
		assertTrue(game.play(new HangManAutoReader("hello", new char[] { 'h', 'e', 'l', 'a', 'a',
				'a', 'a', 'o' })));
		assertFalse(game.play(new HangManAutoReader("hello", new char[] { 'a', 'a', 'a', 'a', 'a',
				'a', 'a', 'o', 'a', 'a' })));
	}

}
