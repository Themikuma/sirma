package com.cit.chat.server;

import com.sirma.itt.javacourse.chat.messages.IClientMessages;
import com.sirma.itt.javacourse.chat.messages.IServerMessages;
import com.sirma.itt.javacourse.chat.server.structures.Client;

public class ClientMessagesReadThread implements Runnable {
	private Client client;
	private UsersManager usersManager;

	/**
	 * @param socket
	 */
	public ClientMessagesReadThread(Client client, UsersManager messageManager) {
		super();
		this.client = client;
		this.usersManager = messageManager;

	}

	@Override
	public void run() {
		String msg = null;

		while ((msg = client.readMessage()) != null) {
			String[] splitMessage = msg.split("[|]");
			if (IClientMessages.CONNECTION_ATTEMPT.toString().equals(splitMessage[0])) {
				client.setUsername(splitMessage[1]);
				usersManager.addUser(client);

			} else if (IClientMessages.CLIENT_MESSAGE.toString().equals(splitMessage[0])) {
				usersManager.broadcastMessage(IServerMessages.MESSAGE + "|" + client.getUsername()
						+ "|" + splitMessage[1]);
			}

		}

		usersManager.removeUser(client);

	}

}
