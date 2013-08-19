package com.sirma.itt.javacourse.chat.client.strategies;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.messages.IServerMessages;

/**
 * Manager of messages. Determines what is the message and decides which method of the main unit is
 * called to handle it.
 * 
 * @author user
 */
public final class Decider {
	private final Client client;
	private static final String SPLITTER = "|";
	private static final char MESSAGESPLITTER = '\0';

	/**
	 * Setting up the main window.
	 * 
	 * @param client
	 *            the client object
	 */
	public Decider(Client client) {
		this.client = client;

	}

	/**
	 * Check the message and decide which method of the main unit can handle it.
	 * 
	 * @param msg
	 *            the message
	 */
	public void decide(final String msg) {
		if (msg.contains("|")) {
			String command = msg.substring(0, msg.indexOf(SPLITTER));
			String message = msg.substring(msg.indexOf(SPLITTER) + 1);
			IServerMessages messages = IServerMessages.valueOf(command);
			switch (messages) {
				case MESSAGE:
					String nickname = message.substring(0, message.indexOf(MESSAGESPLITTER));
					String sentMessage = message.substring(message.indexOf(MESSAGESPLITTER) + 1);
					client.getMainUnit().onMessageAdded(nickname, sentMessage);
					break;
				case ADD_TO_LIST:
					client.getMainUnit().onUserAdded(message);
					break;
				case CLIENT_DISCONNECTED:
					client.getMainUnit().onUserRemoved(message);
					break;
				case USER_LIST:
					client.getMainUnit().onUserList(message);
					break;
				default:
					break;

			}
		}
	}
}
