package com.sirma.itt.javacourse.chat.client.strategies;

import java.util.Date;

import com.sirma.itt.javacourse.chat.client.maincomponents.MainUnit;
import com.sirma.itt.javacourse.chat.messages.IServerMessages;
import com.sirma.itt.javacourse.chat.structures.Message;

/**
 * Manager of messages. Determines what is the message and decides which method of the main unit is
 * called to handle it.
 * 
 * @author user
 */
public class Decider {
	private MainUnit main;

	/**
	 * Setting up the main window.
	 * 
	 * @param main
	 *            the main window
	 */
	public Decider(MainUnit main) {
		this.main = main;
	}

	/**
	 * Check the message and decide which method of the main unit can handle it.
	 * 
	 * @param msg
	 *            the message
	 */
	public void decide(String msg) {
		System.out.println(msg);

		String[] splitMessage = msg.split("[|]");
		if (IServerMessages.USER_LIST.toString().equals(splitMessage[0])) {
			main.onListReloadRequest(splitMessage[1]);
		} else if (IServerMessages.ADD_TO_LIST.toString().equals(splitMessage[0])) {
			main.onUserAdded(splitMessage[1]);
			main.onMessageAdded(new Message("The client " + splitMessage[1] + " has connected.",
					new Date(), "System"));
		} else if (IServerMessages.CLIENT_DISCONNECTED.toString().equals(splitMessage[0])) {
			main.onUserRemoved(splitMessage[1]);
			main.onMessageAdded(new Message("The client " + splitMessage[1] + " has disconnected.",
					new Date(), "System"));
		} else if (IServerMessages.MESSAGE.toString().equals(splitMessage[0])) {
			main.onMessageAdded(new Message(splitMessage[2], new Date(), splitMessage[1]));
		}
	}
}
