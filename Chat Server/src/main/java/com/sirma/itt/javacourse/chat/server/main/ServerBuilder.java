package com.sirma.itt.javacourse.chat.server.main;

import com.sirma.itt.javacourse.chat.server.connectionconfigs.ServerConnectionUnit;
import com.sirma.itt.javacourse.chat.server.connectionconfigs.DialogConnection;
import com.sirma.itt.javacourse.chat.server.maincomponents.ServerMainUnit;
import com.sirma.itt.javacourse.chat.server.maincomponents.SwingServer;

/**
 * Using a builder pattern to build the server from the given main unit and connection unit.
 * 
 * @author user
 */
public class ServerBuilder {
	private ServerMainUnit mainWindow = new SwingServer();
	private ServerConnectionUnit connectionWindow = new DialogConnection();

	/**
	 * Set the main unit of the server.
	 * 
	 * @param window
	 *            the main unit
	 * @return this so we can continue building
	 */
	public ServerBuilder setMainUnit(ServerMainUnit window) {
		this.mainWindow = window;
		return this;
	}

	/**
	 * Set the connection unit of the server.
	 * 
	 * @param window
	 *            the connection unit
	 * @return this so we can continue building
	 */
	public ServerBuilder setConnectionUnit(ServerConnectionUnit window) {
		this.connectionWindow = window;
		return this;
	}

	/**
	 * Build the server from the specified units. If none are specified, use the default ones.
	 * 
	 * @return the built server
	 */
	public Server build() {
		return new Server(mainWindow, connectionWindow);
	}
}
