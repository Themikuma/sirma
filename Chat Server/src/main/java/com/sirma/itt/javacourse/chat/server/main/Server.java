package com.sirma.itt.javacourse.chat.server.main;

import com.sirma.itt.javacourse.chat.server.connectionconfigs.ConnectionUnit;
import com.sirma.itt.javacourse.chat.server.maincomponents.MainUnit;
import com.sirma.itt.javacourse.chat.server.threads.ServerMainThread;

/**
 * The main class of the server. Contains all the necessary components to start.
 * 
 * @author user
 */
public class Server {
	private MainUnit mainUnit;

	private ConnectionUnit connectionUnit;

	/**
	 * Setting up the main and connection units.
	 * 
	 * @param main
	 *            the main unit
	 * @param connect
	 *            the connection unit
	 */
	public Server(MainUnit main, ConnectionUnit connect) {
		this.mainUnit = main;
		this.connectionUnit = connect;
		connectionUnit.setServer(this);
		connectionUnit.start();
	}

	/**
	 * Start a thread that will try starting a server on the specified port. the host to start on
	 * 
	 * @param port
	 *            the port
	 */
	public void tryConnect(String port) {
		int portInt;
		try {
			portInt = Integer.parseInt(port);
			Thread thread = new Thread(new ServerMainThread(portInt, this));
			thread.setDaemon(true);
			thread.start();
		} catch (NumberFormatException e) {
			connectionUnit.connectionFailed("Invalid port format");
		}

	}

	/**
	 * Getter method for mainUnit.
	 * 
	 * @return the mainUnit
	 */
	public MainUnit getMainUnit() {
		return mainUnit;
	}

	/**
	 * Getter method for connectionUnit.
	 * 
	 * @return the connectionUnit
	 */
	public ConnectionUnit getConnectionUnit() {
		return connectionUnit;
	}
}
