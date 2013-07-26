package com.sirma.itt.javacourse.chat.server.connectionconfigs;

import com.sirma.itt.javacourse.chat.server.main.Server;

/**
 * Defines the behavior of all connection units.
 * 
 * @author user
 */
public abstract class ConnectionUnit {
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
	 * Called when the Server object is correctly set.
	 */
	public abstract void start();

	/**
	 * Try to start the server on the given port.
	 * 
	 * @param port
	 *            the port
	 */
	public void tryConnect(String port) {
		server.tryConnect(port);
	}

	/**
	 * Called when a connection has been established.
	 */
	public abstract void connectionEstablished();

	/**
	 * Called when the connection has failed.
	 * 
	 * @param message
	 *            the error
	 */
	public abstract void connectionFailed(String message);
}
