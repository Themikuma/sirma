package com.sirma.itt.javacourse.chat.client.maincomponents;

import java.util.Locale;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.contracts.MainUnit;

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
		if (message.split("[|]").length > 1 && client.isConnected()) {
			client.getServer().sendMessage(message);
		}
	}

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
		if (!client.isConnected())
			client.getConnectionUnit().start();

	}

	@Override
	public void disconnect() {
		if (client.isConnected()) {
			client.getServer().closeConnection();
			client.setConnected(false);
			onServerStopped();
		}
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
