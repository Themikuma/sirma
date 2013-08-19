package com.sirma.itt.javacourse.chat.client.maincomponents;

import java.util.Locale;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.contracts.MainUnit;
import com.sirma.itt.javacourse.chat.messages.IClientMessages;

/**
 * Provides the structure of every main unit. Defines behavior for listening for server messages.
 * 
 * @author user
 */
public abstract class ClientMainUnit implements MainUnit {

	private Client client;

	/**
	 * Sends a message to the server. Lets the implementation decide when to call this method.
	 * 
	 * @param message
	 *            the message to be sent
	 */
	public void sendMessage(String message) {
		client.getServer().sendMessage(IClientMessages.CLIENT_MESSAGE + "|" + message);
	}

	/**
	 * Called when the user first joins the chat and requires a whole list of already connected
	 * users.
	 * 
	 * @param userList
	 *            the list of already connected users
	 */
	public abstract void onUserList(String userList);

	/**
	 * Setter method for client.
	 * 
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public void startConnectionUnit() {
		client.getConnectionUnit().start();
	}

	@Override
	public void closeConnection() {
		client.getServer().closeConnection();
	}

	@Override
	public Locale getLocaleFromIndex(int index) {
		return client.getSupported()[index];
	}

	@Override
	public void setCurrentLocale(Locale locale) {
		client.setLocale(locale);
	}

	@Override
	public Locale getCurrentLocale() {
		return client.getLocale();
	}

}
