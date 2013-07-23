package com.sirma.itt.javacourse.chat.server.maincomponents;

/**
 * Provides structure of the main units.
 * 
 * @author user
 */
public abstract class ServerWindow {

	/**
	 * Method, called when a client has established a connection with the server.
	 * 
	 * @param client
	 *            the client
	 */
	public abstract void onClientConnected(String client);

	/**
	 * Method, called when a client has disconnected from the server.
	 * 
	 * @param client
	 *            the client
	 */
	public abstract void onClientDisconnected(String client);

	/**
	 * Empty method. Some implementations of the main unit don't require a starting configuration so
	 * we are not forcing this method.
	 */
	public void start() {
	}

	/**
	 * Empty method. Some implementations of the main unit don't require a stopping configuration so
	 * we are not forcing this method.
	 */
	public void stop() {
	}
}
