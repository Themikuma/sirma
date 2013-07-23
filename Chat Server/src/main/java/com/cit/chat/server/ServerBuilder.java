package com.cit.chat.server;

import com.cit.chat.server.connectionconfigs.ConnectionUnit;
import com.cit.chat.server.connectionconfigs.DialogConnection;
import com.sirma.itt.javacourse.chat.server.maincomponents.SwingServer;
import com.sirma.itt.javacourse.chat.server.maincomponents.ServerWindow;

/**
 * Using a builder pattern to build the server from the given main unit and connection unit.
 * 
 * @author user
 */
public class ServerBuilder {
	private ServerWindow mainWindow = new SwingServer();
	private ConnectionUnit connectionWindow = new DialogConnection();

	/**
	 * Set the main unit of the server.
	 * 
	 * @param window
	 *            the main unit
	 * @return this so we can continue building
	 */
	public ServerBuilder setMainWindow(ServerWindow window) {
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
	public ServerBuilder setConnectionWindow(ConnectionUnit window) {
		this.connectionWindow = window;
		return this;
	}

	/**
	 * Build the server from the specified units. If none are specified, use the default ones.
	 */
	public void build() {
		mainWindow.start();
		connectionWindow.setParrent(mainWindow);
		connectionWindow.start();
	}
}
