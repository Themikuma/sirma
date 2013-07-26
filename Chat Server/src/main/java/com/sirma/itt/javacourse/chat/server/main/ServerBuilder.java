package com.sirma.itt.javacourse.chat.server.main;

import com.sirma.itt.javacourse.chat.server.connectionconfigs.ConnectionUnit;
import com.sirma.itt.javacourse.chat.server.connectionconfigs.DialogConnection;
import com.sirma.itt.javacourse.chat.server.maincomponents.MainUnit;
import com.sirma.itt.javacourse.chat.server.maincomponents.SwingServer;

/**
 * Using a builder pattern to build the server from the given main unit and connection unit.
 * 
 * @author user
 */
public class ServerBuilder {
	private MainUnit mainWindow = new SwingServer();
	private ConnectionUnit connectionWindow = new DialogConnection();

	/**
	 * Set the main unit of the server.
	 * 
	 * @param window
	 *            the main unit
	 * @return this so we can continue building
	 */
	public ServerBuilder setMainUnit(MainUnit window) {
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
	public ServerBuilder setConnectionUnit(ConnectionUnit window) {
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
