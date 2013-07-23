package com.sirma.itt.javacourse.chat.client.maincomponents;

import com.sirma.itt.javacourse.chat.structures.Message;
import com.sirma.itt.javacourse.chat.structures.Server;

/**
 * Provides the structure of every main unit. Defines behavior for listening for server messages.
 * 
 * @author user
 */
public abstract class MainUnit {

	private ServerMessagesReadThread listener;
	private Server server;

	/**
	 * Empty method. Not every main unit requires some kind of configuration when starting so
	 * overriding is not forced.
	 */
	public void start() {
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
	 * Empty method. Not every implementation requires some kind of configuration when stopping so
	 * overriding is not forced.
	 */
	public void stop() {
	}

	/**
	 * After the connection has been established, start listening for messages from the server. This
	 * message is called from the connection unit.
	 * 
	 * @param server
	 *            the server to listen for messages from
	 */
	public void startListening(Server server) {
		this.server = server;
		listener = new ServerMessagesReadThread(server, this);
		Thread thread = new Thread(listener);
		thread.setDaemon(true);
		thread.start();

	}

	/**
	 * Getter method for server.
	 * 
	 * @return the server
	 */
	public Server getServer() {
		return server;
	}
}
