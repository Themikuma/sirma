package com.sirma.itt.javacourse.designpatterns.task2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testing the Builder pattern.
 * 
 * @author user
 */
public class BlochMailTest {


	/**
	 * Testing the mail construction.
	 */
	@Test
	public void testMailConstruction() {
		
		
		BlochMail mail = new BlochMail.Builder("metodsk").to("metodski").build();
		assertTrue("metodsk".equals(mail.getFrom()));
		assertTrue("metodski".equals(mail.getTo()));
	}
}
