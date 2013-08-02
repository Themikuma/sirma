package com.sirma.itt.javacourse.chat.client.main;

import java.util.Locale;
import java.util.ResourceBundle;

import com.sirma.itt.javacourse.chat.client.maincomponents.ClientMainUnit;
import com.sirma.itt.javacourse.chat.client.threads.ServerConnectionThread;
import com.sirma.itt.javacourse.chat.client.threads.ServerMessagesReadThread;
import com.sirma.itt.javacourse.chat.connectionconfigs.ClientConnectionUnit;
import com.sirma.itt.javacourse.chat.contracts.ConnectionUnit;
import com.sirma.itt.javacourse.chat.contracts.MainUnit;
import com.sirma.itt.javacourse.chat.structures.Server;

/**
 * The main object, mediator. Contains all the needed components for the client and manages the
 * communication between them.
 * 
 * @author user
 */
public class Client {
	private MainUnit mainUnit;
	private ConnectionUnit connectionUnit;
	private Server server;
	private boolean isConnected;
	private Locale[] supported = { Locale.ENGLISH, new Locale("bg") };
	private Locale locale = Locale.getDefault();

	/**
	 * Setting up the main and connection units.
	 * 
	 * @param mainUnit
	 *            the main unit
	 * @param connectionUnit
	 *            the connection unit
	 */
	public Client(ClientMainUnit mainUnit, ClientConnectionUnit connectionUnit) {
		super();
		this.mainUnit = mainUnit;
		this.connectionUnit = connectionUnit;
		mainUnit.setClient(this);
		connectionUnit.setClient(this);
		mainUnit.start();
	}

	/**
	 * Try connecting to the given host:port with the given username.
	 * 
	 * @param host
	 *            the host to connect to
	 * @param username
	 *            the username to connect with
	 * @param port
	 *            the port of the host
	 */
	public void tryConnect(String host, String username, String port) {
		ResourceBundle errorsBundle = ResourceBundle.getBundle("DialogBundle", locale);
		int portInt = 0;
		try {
			portInt = Integer.parseInt(port);
			ServerConnectionThread connectionListener = new ServerConnectionThread(host, username,
					portInt, this);
			Thread thread = new Thread(connectionListener);
			thread.start();
		} catch (NumberFormatException e) {
			connectionUnit.connectionRefused("malformedPort");
		}

	}

	/**
	 * Start listening for messages on the already established connection.
	 */
	public void startListening() {
		ServerMessagesReadThread thread = new ServerMessagesReadThread(this);
		Thread msgThread = new Thread(thread);
		msgThread.start();
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
	 * Setter method for server.
	 * 
	 * @param server
	 *            the server to set
	 */
	public void setServer(Server server) {
		this.server = server;
	}

	/**
	 * Getter method for isConnected.
	 * 
	 * @return the isConnected
	 */
	public boolean isConnected() {
		return isConnected;
	}

	/**
	 * Setter method for isConnected.
	 * 
	 * @param isConnected
	 *            the isConnected to set
	 */
	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	/**
	 * Getter method for locale.
	 * 
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Setter method for locale.
	 * 
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
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
