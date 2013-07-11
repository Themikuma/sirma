package com.sirma.itt.javacourse.gui.task6.Server;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;
import com.sirma.itt.javacourse.gui.task6.ChannelManager;

/**
 * Handles the sending/receiving of messages.
 * 
 * @author user
 */
public class ServerMessageListener implements Runnable {
	private ClientWrapper client;
	private ChannelManager mediator;

	/**
	 * Setting up the socket, mediator and model.
	 * 
	 * @param client
	 *            the client
	 * @param mediator
	 *            the mediator that handles the messages
	 */
	public ServerMessageListener(ClientWrapper client, ChannelManager mediator) {
		super();
		this.client = client;
		this.mediator = mediator;

	}

	@Override
	public void run() {
		String msg = null;
		while ((msg = client.receiveMessage()) != null) {
			if ("disconnect".equals(msg)) {
				mediator.removeUser(client);
				break;
			} else {
				mediator.addUser(msg.split(":")[1], client);
			}

		}
		client.closeConnection();
		System.out.println("socket closed");
	}
}
