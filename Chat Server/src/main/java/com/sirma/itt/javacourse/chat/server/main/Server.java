package com.sirma.itt.javacourse.chat.server.main;

import java.net.ServerSocket;
import java.util.Locale;

import com.sirma.itt.javacourse.chat.contracts.ConnectionUnit;
import com.sirma.itt.javacourse.chat.contracts.MainUnit;
import com.sirma.itt.javacourse.chat.server.connectionconfigs.ServerConnectionUnit;
import com.sirma.itt.javacourse.chat.server.maincomponents.ServerMainUnit;
import com.sirma.itt.javacourse.chat.server.threads.ServerMainThread;

/**
 * The main class of the server. Contains all the necessary components to start.
 * 
 * @author user
 */
public class Server {
	private MainUnit mainUnit;
	private ConnectionUnit connectionUnit;
	private ServerSocket server;
	private Locale[] supported = { Locale.ENGLISH, new Locale("bg") };
	private Locale currentLocale = Locale.getDefault();

	/**
	 * Setting up the main and connection units.
	 * 
	 * @param main
	 *            the main unit
	 * @param connect
	 *            the connection unit
	 */
	public Server(ServerMainUnit main, ServerConnectionUnit connect) {
		this.mainUnit = main;
		this.connectionUnit = connect;
		connect.setServer(this);
		main.setServer(this);
		mainUnit.start();
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
			// thread.setDaemon(true);
			thread.start();
		} catch (NumberFormatException e) {
			connectionUnit.connectionRefused("malformedPort");
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

	/**
	 * Getter method for server.
	 * 
	 * @return the server
	 */
	public ServerSocket getServer() {
		return server;
	}

	/**
	 * Setter method for server.
	 * 
	 * @param server
	 *            the server to set
	 */
	public void setServer(ServerSocket server) {
		this.server = server;
	}

	/**
	 * Getter method for currentLocale.
	 * 
	 * @return the currentLocale
	 */
	public Locale getCurrentLocale() {
		return currentLocale;
	}

	/**
	 * Setter method for currentLocale.
	 * 
	 * @param currentLocale
	 *            the currentLocale to set
	 */
	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}

	/**
	 * Getter method for supported.
	 * 
	 * @return the supported
	 */
	public Locale[] getSupported() {
		return supported;
	}
}
