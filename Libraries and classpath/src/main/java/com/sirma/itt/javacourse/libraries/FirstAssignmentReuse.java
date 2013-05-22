package com.sirma.itt.javacourse.libraries;

import com.sirma.itt.javacourse.intro.ArrayProcessing;
import com.sirma.itt.javacourse.intro.HangManGame;
import com.sirma.itt.javacourse.intro.HangManManualReader;
import com.sirma.itt.javacourse.intro.RandomString;

/**
 * A Class reusing the classes from the first assignment.
 * 
 * @author user
 */
public final class FirstAssignmentReuse {

	/**
	 * Private constructor, throwing an error, preventing anyone from instantiating this class.
	 */
	private FirstAssignmentReuse() {
	}

	/**
	 * Reusing the ArrayProcessing class.
	 */
	public static void startArrayProcessing() {
		ArrayProcessing processor = new ArrayProcessing();
		System.out.println(processor.getMinElement(new int[] { 1, 2, -5, 4, 5 }));

	}

	/**
	 * Reusing the HangManGame class.
	 */
	public static void startHangMan() {
		HangManGame game = new HangManGame();
		game.play(new HangManManualReader());
	}

	/**
	 * Reusing the RandomString class.
	 */
	public static void startRandomString() {
		RandomString random = new RandomString();
		System.out.println(random.generateString(10));
	}

}
