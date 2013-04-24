package com.sirma.itt.javacourse.intro;

/**
 * Class with a method, generating random strings.
 * 
 * @author user
 */
public class RandomStringGenerator {
	private static String alphabet;

	/**
	 * Constructor setting the initial alphabet.
	 */
	protected RandomStringGenerator() {
		for (int i = 0; i < 9; i++) {
			alphabet += i;
		}
		for (int i = 65; i < 91; i++) {
			alphabet += (char) i;
		}
		for (int i = 97; i < 123; i++) {
			alphabet += (char) i;
		}
	}

	/**
	 * Generating random strings with fixed length containing numbers, capital and small letters.
	 * 
	 * @param arrayLength
	 *            the length of the string to be generated
	 * @return the generated string
	 */
	public String generateString(int arrayLength) {
		String result = "";
		int alphabetLength = alphabet.length();
		for (int i = 0; i < arrayLength; i++) {
			int randomNumber = (int) (Math.random() * alphabetLength);
			result += alphabet.charAt(randomNumber);
		}
		return result;
	}
}
