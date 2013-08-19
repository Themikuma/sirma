package com.sirma.itt.javacourse.chat.client.threads;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.client.strategies.Decider;

/**
 * The thread that is going to listen for messages from the server. Once a message is received, it
 * is passed to the {@link Decider}.
 * 
 * @author user
 */
public class ServerMessagesReadThread implements Runnable {

	private final Decider decider;
	private final Client client;

	/**
	 * Setting up the server and the main unit.
	 * 
	 * @param client
	 *            the client mediator
	 */
	public ServerMessagesReadThread(Client client) {
		this.client = client;
		decider = new Decider(client);
	}

	@Override
	public void run() {
		String msg;
		while ((msg = client.getServer().getMessage()) != null) {
			decider.decide(msg);
		}
		client.getServer().closeConnection();
		client.getMainUnit().onConnectionClosed();
	}
}
