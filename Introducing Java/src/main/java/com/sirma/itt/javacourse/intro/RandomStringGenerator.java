package com.sirma.itt.javacourse.intro;

/**
 * Class with a method, generating random strings.
 * 
 * @author user
 */
public class RandomStringGenerator {
	private static final String ALPHABET;

	static {
		String localAlphabet = "";
		for (int i = 0; i < 9; i++) {
			localAlphabet += i;
		}
		for (int i = 65; i < 91; i++) {
			localAlphabet += (char) i;
		}
		for (int i = 97; i < 123; i++) {
			localAlphabet += (char) i;
		}
		ALPHABET = localAlphabet;
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
		int alphabetLength = ALPHABET.length();
		for (int i = 0; i < arrayLength; i++) {
			int randomNumber = (int) (Math.random() * alphabetLength);
			result += ALPHABET.charAt(randomNumber);
		}
		return result;
	}
}
