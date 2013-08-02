package com.sirma.itt.javacourse.chat.server.threads;

import com.sirma.itt.javacourse.chat.messages.IClientMessages;
import com.sirma.itt.javacourse.chat.messages.IServerMessages;
import com.sirma.itt.javacourse.chat.server.UsersManager;
import com.sirma.itt.javacourse.chat.server.main.Server;
import com.sirma.itt.javacourse.chat.server.structures.Client;

/**
 * The runnable object that is going to listen for messages from the client.
 * 
 * @author user
 */
public class ClientMessagesReadThread implements Runnable {
	private Client client;
	private UsersManager usersManager;
	private Server server;
	private static final String SPLITTER = "|";

	/**
	 * Set up the client and the messageManager.
	 * 
	 * @param client
	 *            the client
	 * @param messageManager
	 *            the manager
	 */
	public ClientMessagesReadThread(Client client, UsersManager messageManager, Server server) {
		super();
		this.client = client;
		this.usersManager = messageManager;
		this.server = server;

	}

	@Override
	public void run() {
		String msg = null;

		while ((msg = client.readMessage()) != null) {
			System.out.println(msg);
			String command = msg.substring(0, msg.indexOf(SPLITTER));
			String message = msg.substring(msg.indexOf(SPLITTER) + 1);
			if (IClientMessages.CONNECTION_ATTEMPT.toString().equals(command)) {
				client.setUsername(message);
				if (usersManager.addUser(client)) {
					client.sendMessage(IServerMessages.NICK_OK.toString());
					server.getMainUnit().onUserAdded(client.getUsername());
					String users = usersManager.generateUsernameString(client);
					if (!"".equals(users))
						usersManager.sendMessage(client, IServerMessages.USER_LIST + SPLITTER
								+ users);
					usersManager.broadcastMessage(IServerMessages.ADD_TO_LIST + SPLITTER
							+ client.getUsername());
				} else {
					usersManager.sendMessage(client, IServerMessages.INVALID_NICK.toString());
					return;
				}

			} else if (IClientMessages.CLIENT_MESSAGE.toString().equals(command)) {
				usersManager.broadcastMessage(IServerMessages.MESSAGE + "|" + client.getUsername()
						+ "|" + message);
				server.getMainUnit().addMessage(client.getUsername(), message);
			}

		}
		server.getMainUnit().onUserRemoved(client.getUsername());
		usersManager.removeUser(client);

	}
}
