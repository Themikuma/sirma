package com.sirma.itt.javacourse.chat.client.strategies;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.messages.IServerMessages;

/**
 * Manager of messages. Determines what is the message and decides which method of the main unit is
 * called to handle it.
 * 
 * @author user
 */
public class Decider {
	private Client client;

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
	public void decide(String msg) {

		String[] splitMessage = msg.split("[|]");
		if (IServerMessages.USER_LIST.toString().equals(splitMessage[0])) {
			for (String user : splitMessage[1].split(","))
				client.getMainUnit().onUserAdded(user);
		} else if (IServerMessages.ADD_TO_LIST.toString().equals(splitMessage[0])) {
			client.getMainUnit().onUserAdded(splitMessage[1]);
		} else if (IServerMessages.CLIENT_DISCONNECTED.toString().equals(splitMessage[0])) {
			client.getMainUnit().onUserRemoved(splitMessage[1]);
		} else if (IServerMessages.MESSAGE.toString().equals(splitMessage[0])) {
			client.getMainUnit().addMessage(splitMessage[1], splitMessage[2]);
		}
	}
}
