package com.sirma.itt.javacourse.chat.client.maincomponents;

import java.util.Locale;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.structures.Message;

/**
 * Provides the structure of every main unit. Defines behavior for listening for server messages.
 * 
 * @author user
 */
public abstract class MainUnit {

	private Client client;

	/**
	 * Starts the connection unit. Lets the implementation decide when to call this method.
	 */
	public void startConnectionUnit() {
		if (!client.isConnected())
			client.getConnectionUnit().start();

	}

	/**
	 * Disconnects from the server. Lets the implementation decide when to call this method.
	 */
	public void disconnect() {
		if (client.isConnected()) {
			client.getServer().closeConnection();
			client.setConnected(false);
			onServerStopped();
		}
	}

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
	 * Log a message.
	 * 
	 * @param message
	 *            the message to be logged
	 */
	public void logMessage(String message) {
		client.getLogger().info(message);
	}

	/**
	 * Log an error.
	 * 
	 * @param message
	 *            the message of the error to be logged
	 */
	public void logError(String message) {
		client.getLogger().error(message);

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

	/**
	 * Get the supported locale from the array of supported locales.
	 * 
	 * @param index
	 *            the index of the locale
	 * @return the locale
	 */
	public Locale getSupportedLocale(int index) {
		return client.getSupported()[index];
	}

	/**
	 * Set the currently used locale to be used from the main unit and the connection unit.
	 * 
	 * @param locale
	 *            the locale
	 */
	public void setLocale(Locale locale) {
		client.setLocale(locale);
	}

	/**
	 * Get the current locale that is being used by all components of the client object.
	 * 
	 * @return the locale
	 */
	public Locale getCurrentLocale() {
		return client.getLocale();
	}

	/**
	 * Called when an user is added.
	 * 
	 * @param user
	 *            the nickname of the user
	 */
	public abstract void onUserAdded(String user);

	/**
	 * Called when an user is removed.
	 * 
	 * @param user
	 *            the nickname of the user
	 */
	public abstract void onUserRemoved(String user);

	/**
	 * Called when a whole list of users is sent and a reload is required.
	 * 
	 * @param users
	 *            the list of users
	 */
	public abstract void onListReloadRequest(String users);

	/**
	 * Called when a message is added.
	 * 
	 * @param message
	 *            the message to be displayed.
	 */
	public abstract void onMessageAdded(Message message);

	/**
	 * Called once the Client object has been created and all of it's components are set up
	 * correctly.
	 */
	public abstract void start();

	/**
	 * Called when the server has been stopped or a disconnect has been forced.
	 */
	public abstract void onServerStopped();

}
