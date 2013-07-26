package com.sirma.itt.javacourse.chat.connectionconfigs;

import java.util.Locale;

import com.sirma.itt.javacourse.chat.client.main.Client;

/**
 * The structure of each connection unit. Defines behavior for connecting to the server.
 * 
 * @author user
 */
public abstract class ConnectionUnit {
	private Client client;

	/**
	 * Try to establish a connection on the given host port with the given username. Lets the
	 * implementation decide when to call this method.
	 * 
	 * @param host
	 *            the host to try to connect to
	 * @param port
	 *            the port to try to connect on
	 * @param username
	 *            the username to try to connect with
	 */
	public void connect(String host, String port, String username) {
		client.tryConnect(host, username, port);
	}

	/**
	 * Get the currently used locale from the main client class.
	 * 
	 * @return the locale
	 */
	public Locale getCurrentLocale() {
		return client.getLocale();
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
	 * Called when the main unit implementation decides. Starts the connection unit implementation.
	 */
	public abstract void start();

	/**
	 * Called when a succesfull connection is established.
	 */
	public abstract void connectionEstablished();

	/**
	 * Called when a connection is not established for some reason.
	 * 
	 * @param error
	 *            the error that occurred during the connection
	 */
	public abstract void connectionRefused(String error);
}
