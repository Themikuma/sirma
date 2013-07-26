package com.sirma.itt.javacourse.chat.client.strategies;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.messages.IServerMessages;
import com.sirma.itt.javacourse.chat.structures.Message;

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
		ResourceBundle hoursBundle = ResourceBundle.getBundle("HoursBundle", client.getLocale());
		ResourceBundle messageBundle = ResourceBundle.getBundle("MessagesBundle",
				client.getLocale());
		MessageFormat messageFormatter = new MessageFormat("");
		messageFormatter.setLocale(client.getLocale());

		DateFormat formatter = new SimpleDateFormat(hoursBundle.getString("hours"));

		String[] splitMessage = msg.split("[|]");
		if (IServerMessages.USER_LIST.toString().equals(splitMessage[0])) {
			client.getMainUnit().onListReloadRequest(splitMessage[1]);
		} else if (IServerMessages.ADD_TO_LIST.toString().equals(splitMessage[0])) {
			messageFormatter.applyPattern(messageBundle.getString("connectMessage"));
			client.getMainUnit().onUserAdded(splitMessage[1]);
			client.getMainUnit().onMessageAdded(
					new Message(messageFormatter.format(splitMessage),
							formatter.format(new Date()), "System"));
		} else if (IServerMessages.CLIENT_DISCONNECTED.toString().equals(splitMessage[0])) {
			messageFormatter.applyPattern(messageBundle.getString("disconnectMessage"));
			client.getMainUnit().onUserRemoved(splitMessage[1]);
			client.getMainUnit().onMessageAdded(
					new Message(messageFormatter.format(splitMessage),
							formatter.format(new Date()), "System"));
		} else if (IServerMessages.MESSAGE.toString().equals(splitMessage[0])) {
			client.getMainUnit().onMessageAdded(
					new Message(splitMessage[2], formatter.format(new Date()), splitMessage[1]));
		}
	}
}
