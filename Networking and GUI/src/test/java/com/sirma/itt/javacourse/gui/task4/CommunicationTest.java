package com.sirma.itt.javacourse.gui.task4;

import java.io.IOException;

import org.junit.Test;

import com.sirma.itt.javacourse.gui.task4.Client.Client;
import com.sirma.itt.javacourse.gui.task4.Client.ClientListener;
import com.sirma.itt.javacourse.gui.task4.Server.Server;

public class CommunicationTest {

	@Test
	public void test() throws IOException {
		Server server = new Server();
		Client client = new Client();
		Client secondClient = new Client();
		server.start();
		client.connect();
		secondClient.connect();
		ClientListener listener = new ClientListener(client);
		ClientListener secondListener = new ClientListener(secondClient);
		server.acceptClient();
		System.out.println(listener.waitForMessage());
		server.acceptClient();

		System.out.println(secondListener.waitForMessage());
		System.out.println(listener.waitForMessage());

	}

}
