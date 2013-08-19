package com.sirma.itt.javacourse.chat.server.connectioncomponents;

import java.util.Locale;

import com.sirma.itt.javacourse.chat.contracts.ConnectionUnit;
import com.sirma.itt.javacourse.chat.server.main.Server;

/**
 * Defines the behavior of all connection units.
 * 
 * @author user
 */
public abstract class ServerConnectionUnit implements ConnectionUnit {
	private Server server;

	/**
	 * Setter method for server.
	 * 
	 * @param server
	 *            the server to set
	 */
	public void setServer(Server server) {
		this.server = server;
	}

	/**
	 * Getter method for server.
	 * 
	 * @return the server
	 */
	public Server getServer() {
		return server;
	}

	/**
	 * Try to start the server on the given port.
	 * 
	 * @param port
	 *            the port
	 */
	public void tryConnect(String port) {
		server.startServer(port);
	}

	@Override
	public Locale getCurrentLocale() {
		return server.getCurrentLocale();
	}
}
