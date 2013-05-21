package com.sirma.itt.javacourse.refanreg.task5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class, testing the EmailValidator class.
 * 
 * @author user
 */
public class EmailValidatorTest {

	/**
	 * Testing the isEmailValid method of the EmailValidator class.
	 */
	@Test
	public void testIsEmailValid() {
		assertTrue(EmailValidator.isEmailValid("metodski2@gmail.com"));
		assertTrue(EmailValidator.isEmailValid("qwer@abv.bg"));
		assertFalse(EmailValidator.isEmailValid("qwer@abv.a"));
		assertFalse(EmailValidator.isEmailValid("metodski2gmail."));
	}

}
