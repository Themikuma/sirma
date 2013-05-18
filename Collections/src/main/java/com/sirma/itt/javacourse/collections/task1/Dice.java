package com.sirma.itt.javacourse.collections.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The dice class containing a map with rolled pair of dices and number of rolls.
 * 
 * @author user
 */
public class Dice {
	private Map<String, List<Integer>> rollsHistory = new HashMap<String, List<Integer>>();
	private int numRolls = 1;

	/**
	 * Rolls the dices, generating two random ints from 1 to 6, checking if the pair is already in
	 * the map and adding the pair with the number of the current dice throw.
	 */
	// TODO get rid of repetition
	public void rollDices() {
		Random randomIntGenerator = new Random();
		int firstDice = randomIntGenerator.nextInt(6) + 1;
		int secondDice = randomIntGenerator.nextInt(6) + 1;
		String result = firstDice + "," + secondDice;
		List<Integer> alreadyRolled = rollsHistory.get(result);
		if (alreadyRolled == null) {
			alreadyRolled = new ArrayList<>();
			rollsHistory.put(result, alreadyRolled);
		}
		alreadyRolled.add(numRolls++);

	}

	/**
	 * An overload method, taking two ints instead of generating random numbers for testing
	 * purposes.
	 * 
	 * @param firstDice
	 *            the number of the first dice.
	 * @param secondDice
	 *            the number of the second dice.
	 */
	public void rollDices(int firstDice, int secondDice) {
		String result = firstDice + "," + secondDice;
		List<Integer> alreadyRolled = rollsHistory.get(result);
		if (alreadyRolled == null) {
			alreadyRolled = new ArrayList<>();
			rollsHistory.put(result, alreadyRolled);
		}
		alreadyRolled.add(numRolls++);

	}

	/**
	 * Getter method for rollsHistory.
	 * 
	 * @return the rollsHistory
	 */
	public Map<String, List<Integer>> getRollsHistory() {
		return rollsHistory;
	}

	/**
	 * Setter method for rollsHistory.
	 * 
	 * @param rollsHistory
	 *            the rollsHistory to set
	 */
	public void setRollsHistory(Map<String, List<Integer>> rollsHistory) {
		this.rollsHistory = rollsHistory;
	}
}
