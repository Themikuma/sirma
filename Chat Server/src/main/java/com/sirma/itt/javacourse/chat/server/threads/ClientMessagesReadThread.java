package com.sirma.itt.javacourse.chat.server.threads;

import java.io.IOException;

import com.sirma.itt.javacourse.chat.messages.IClientMessages;
import com.sirma.itt.javacourse.chat.messages.IServerMessages;
import com.sirma.itt.javacourse.chat.server.main.Server;
import com.sirma.itt.javacourse.chat.server.main.UsersManager;
import com.sirma.itt.javacourse.chat.server.structures.Client;

/**
 * The runnable object that is going to listen for messages from the client.
 * 
 * @author user
 */
public final class ClientMessagesReadThread implements Runnable {
	private final Client client;
	private final UsersManager usersManager;
	private final Server server;
	private static final String SPLITTER = "|";

	/**
	 * Set up the client, server and the messageManager.
	 * 
	 * @param client
	 *            the client
	 * @param server
	 *            the main server object
	 * @throws IOException
	 *             an io exception occurs while trying to open the socket's streams.
	 */
	public ClientMessagesReadThread(Client client, Server server) throws IOException {
		super();
		this.client = client;
		client.openStreams();
		client.startSenderThread();
		this.usersManager = server.getUsersManager();
		this.server = server;

	}

	@Override
	public void run() {
		String msg = null;

		while ((msg = client.readMessage()) != null) {
			if (msg.contains(SPLITTER)) {
				String command = msg.substring(0, msg.indexOf(SPLITTER));
				String message = msg.substring(msg.indexOf(SPLITTER) + 1);
				if (!message.isEmpty() && message.length() < 200) {
					if (!client.isVerified()
							&& IClientMessages.CONNECTION_ATTEMPT.toString().equals(command)) {
						client.setUsername(message);
						if (usersManager.addUser(client)) {
							client.sendMessage(IServerMessages.NICK_OK.toString());
							client.setVerified(true);
							server.getMainUnit().onUserAdded(client.getUsername());
							String users = usersManager.generateUsernameString(client);
							if (!"".equals(users))
								usersManager.sendMessage(client, IServerMessages.USER_LIST
										+ SPLITTER + users);
							usersManager.broadcastMessage(IServerMessages.ADD_TO_LIST + SPLITTER
									+ client.getUsername());
						} else {
							usersManager.sendMessage(client,
									IServerMessages.INVALID_NICK.toString());
						}
					} else if (IClientMessages.CLIENT_MESSAGE.toString().equals(command)
							&& client.isVerified()) {
						StringBuilder sb = new StringBuilder(message);
						sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
						usersManager.broadcastMessage(IServerMessages.MESSAGE + "|"
								+ client.getUsername() + '\0' + sb.toString());
						server.getMainUnit().onMessageAdded(client.getUsername(), message);
					}
				}

			}
		}
		if (client.isVerified()) {
			server.getMainUnit().onUserRemoved(client.getUsername());
			usersManager.removeUser(client);
		} else
			client.closeConnection();

	}
}
