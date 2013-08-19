package com.sirma.itt.javacourse.chat.client.connectioncomponents;

import java.util.Locale;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.contracts.ConnectionUnit;

/**
 * The structure of each connection unit. Defines behavior for connecting to the server.
 * 
 * @author user
 */
public abstract class ClientConnectionUnit implements ConnectionUnit {
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

	@Override
	public Locale getCurrentLocale() {
		return client.getLocale();
	}

	/**
	 * Setter method of the client.
	 * 
	 * @param client
	 *            the Client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Getter method for client.
	 * 
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

}
