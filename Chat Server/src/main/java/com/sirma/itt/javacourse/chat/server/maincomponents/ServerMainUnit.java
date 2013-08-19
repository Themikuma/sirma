package com.sirma.itt.javacourse.chat.server.maincomponents;

import java.io.IOException;
import java.util.Locale;

import com.sirma.itt.javacourse.chat.contracts.MainUnit;
import com.sirma.itt.javacourse.chat.server.main.Server;

/**
 * Provides structure of the main units.
 * 
 * @author user
 */
public abstract class ServerMainUnit implements MainUnit {
	private Server server;

	/**
	 * Called when a valid connection has been established (The server has started).
	 * 
	 * @param port
	 *            the port on which the server has started
	 */
	public abstract void onConnectionEstablished(String port);

	@Override
	public void startConnectionUnit() {
		server.getConnectionUnit().start();
	}

	@Override
	public void closeConnection() throws IOException {
		server.stopServer();
		server.getUsersManager().closeConnections();
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
	 * Setter method for server.
	 * 
	 * @param server
	 *            the server to set
	 */
	public void setServer(Server server) {
		this.server = server;
	}

	@Override
	public Locale getCurrentLocale() {
		return server.getCurrentLocale();
	}

	@Override
	public void setCurrentLocale(Locale locale) {
		server.setCurrentLocale(locale);
	}

	@Override
	public Locale getLocaleFromIndex(int index) {
		return server.getSupported()[index];
	}
}
