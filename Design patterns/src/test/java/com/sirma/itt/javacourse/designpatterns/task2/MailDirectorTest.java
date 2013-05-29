package com.sirma.itt.javacourse.designpatterns.task2;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the Builder pattern.
 * 
 * @author user
 */
public class MailDirectorTest {
	private MailDirector mailDirector;
	private Mail email;

	/**
	 * Setting up the maildirector and the email to be constructed before each test.
	 * 
	 * @throws Exception
	 *             if something goes wrong
	 */
	@Before
	public void setUp() throws Exception {
		email = new Mail();
		mailDirector = new MailDirector(new CustomMailBuilder(email));
	}

	/**
	 * Testing the mail construction method of the mail director.
	 */
	@Test
	public void testMailConstruction() {
		mailDirector.constructMail("metodski", "metodski", "hello", "asdasd", "never", "file.txt",
				"file1.txt", "file3.txt");
		assertTrue("metodski".equals(email.getFrom()));
		assertTrue("file1.txt".equals(email.getAttachments()[1]));
	}
}
