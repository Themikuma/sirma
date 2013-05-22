package com.sirma.itt.javacourse.collections.task1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Testing the dice class.
 * 
 * @author user
 */
public class DiceTest {

	/**
	 * Tests to see if the pair of dices thrown is being added correctly to the map.
	 */
	@Test
	public void testRollDicesAddition() {
		Dice diceRoller = new Dice();
		diceRoller.rollDices(1, 1);
		assertTrue(diceRoller.getRollsHistory().get("1,1") != null);
		assertEquals(1, diceRoller.getRollsHistory().get("1,1").get(0).intValue());
	}

	/**
	 * Testing the findDices method. It should return the specified combination, number of times
	 * that the combination has been thrown and the indexes of throws which have resulted in the
	 * combination.
	 */
	@Test
	public void testRollDicesIntInt() {
		Dice diceRoller = new Dice();
		diceRoller.rollDices(1, 1);
		diceRoller.rollDices(3, 1);
		diceRoller.rollDices(6, 6);
		diceRoller.rollDices(3, 1);
		diceRoller.rollDices(1, 1);
		List<Integer> result = new ArrayList<Integer>();
		result.add(2);
		result.add(4);
		assertTrue(findDices(diceRoller, "3,1").equals(result));
		assertEquals(null, findDices(diceRoller, "2,3"));

	}

	/**
	 * finds the number of throws, and the indexes of the throws that have resulted in the
	 * combination.
	 * 
	 * @param diceRoller
	 *            the diceroller class containing the map.
	 * @param key
	 *            the combination to be found in the map.
	 * @return list of indexes at which the combination has been rolled, null if there are no
	 *         indexes
	 */
	public List<Integer> findDices(Dice diceRoller, String key) {
		return diceRoller.getRollsHistory().get(key);
	}
}
