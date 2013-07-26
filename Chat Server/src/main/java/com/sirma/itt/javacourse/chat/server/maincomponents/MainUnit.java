package com.sirma.itt.javacourse.chat.server.maincomponents;


/**
 * Provides structure of the main units.
 * 
 * @author user
 */
public abstract class MainUnit {

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
	 * Log a message.
	 * 
	 * @param message
	 *            the message to log
	 */
	public abstract void logMessage(String message);

	/**
	 * Called when a connection is established from the connection unit.
	 */
	public abstract void start();

}
