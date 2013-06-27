package com.sirma.itt.javacourse.gui.task3;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.javacourse.gui.task3.Client.Client;
import com.sirma.itt.javacourse.gui.task3.Server.Server;

public class CommunicationTest {

	@Test
	public void testClientConnection() {
		String msg = null;
		Server server = new Server();
		Client client = new Client();

		server.start();

		client.connect();
		server.acceptClient();
		msg = client.waitForMessage();
		assertTrue(msg.contains("Hello"));
	}
}
