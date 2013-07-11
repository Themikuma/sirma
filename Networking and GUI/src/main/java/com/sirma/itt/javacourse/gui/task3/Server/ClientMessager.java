package com.sirma.itt.javacourse.gui.task3.Server;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;

/**
 * A runnable object that sends a message to a given client.
 * 
 * @author user
 */
public class ClientMessager implements Runnable {

	private ClientWrapper client;
	private String message;

	/**
	 * Init the client and the message.
	 * 
	 * @param client
	 *            the client
	 * @param message
	 *            the message
	 */
	public ClientMessager(ClientWrapper client, String message) {
		super();
		this.client = client;
		this.message = message;
	}

	@Override
	public void run() {
		client.sendMessage(message);
		client.closeConnection();
	}

}
