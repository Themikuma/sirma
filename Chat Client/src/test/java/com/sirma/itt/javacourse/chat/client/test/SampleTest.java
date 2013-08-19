package com.sirma.itt.javacourse.chat.client.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.javacourse.chat.client.main.Client;

/**
 * Unit tests for the client.
 * 
 * @author user
 */
public class SampleTest {

	/**
	 * Test the builder of the {@link Client}.
	 */
	@Test
	public void testClientBuilder() {
		Client client;
		client = new Client.Builder().build();
		assertTrue(client != null);
	}

}
