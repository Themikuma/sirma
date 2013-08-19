package com.sirma.itt.javacourse.chat.client.main;

import java.util.Locale;

import com.sirma.itt.javacourse.chat.client.connectionconfigs.ClientConnectionUnit;
import com.sirma.itt.javacourse.chat.client.connectionconfigs.DialogConnection;
import com.sirma.itt.javacourse.chat.client.maincomponents.ClientMainUnit;
import com.sirma.itt.javacourse.chat.client.maincomponents.SwingClient;
import com.sirma.itt.javacourse.chat.client.structures.Server;
import com.sirma.itt.javacourse.chat.client.threads.ServerConnectionThread;
import com.sirma.itt.javacourse.chat.client.threads.ServerMessagesReadThread;

/**
 * The main object, mediator. Contains all the needed components for the client and manages the
 * communication between them.
 * 
 * @author user
 */
public final class Client {
	private final ClientMainUnit mainUnit;
	private final ClientConnectionUnit connectionUnit;
	private Server server;
	private final Locale[] supportedLocales = { Locale.ENGLISH, new Locale("bg") };
	private Locale currentLocale = Locale.getDefault();

	/**
	 * Setting up the main and connection units.
	 * 
	 * @param builder
	 *            the Builder containing the main and connection units
	 */
	private Client(Builder builder) {
		this.mainUnit = builder.mainFrame;
		this.connectionUnit = builder.connectionFrame;
		mainUnit.setClient(this);
		connectionUnit.setClient(this);
		mainUnit.start();
	}

	/**
	 * Check if a connection to the server has been established.
	 * 
	 * @return true if it has, false otherwise
	 */
	public boolean isConnected() {
		if (server == null || server.getSocket().isClosed())
			return false;
		return true;
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
		int portInt = 0;
		try {
			portInt = Integer.parseInt(port);
			ServerConnectionThread connectionListener = new ServerConnectionThread(host, username,
					portInt, this);
			Thread thread = new Thread(connectionListener);
			thread.setName("Connection thread");
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
		msgThread.setName("Listening Thread");
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
	public ClientMainUnit getMainUnit() {
		return mainUnit;
	}

	/**
	 * Getter method for connectionUnit.
	 * 
	 * @return the connectionUnit
	 */
	public ClientConnectionUnit getConnectionUnit() {
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
	 * Getter method for locale.
	 * 
	 * @return the locale
	 */
	public Locale getLocale() {
		return currentLocale;
	}

	/**
	 * Setter method for locale.
	 * 
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(Locale locale) {
		this.currentLocale = locale;
	}

	/**
	 * Getter method for supported.
	 * 
	 * @return the supported
	 */
	public Locale[] getSupported() {
		return supportedLocales;
	}

	/**
	 * Implementing the builder pattern as a static nested class in order to increase encapsulation.
	 * By default the builder uses a {@link SwingClient} and a {@link DialogConnection}. They can be
	 * changed in the builder via method chaining.
	 * 
	 * @author user
	 */
	public static class Builder {
		private ClientMainUnit mainFrame = new SwingClient();
		private ClientConnectionUnit connectionFrame = new DialogConnection();

		/**
		 * Set the main unit of the chat client.
		 * 
		 * @param mainFrame
		 *            the unit implementation
		 * @return this so we can continue building
		 */
		public Builder setMainUnit(ClientMainUnit mainFrame) {
			this.mainFrame = mainFrame;
			return this;
		}

		/**
		 * Set the connection unit of the chat client.
		 * 
		 * @param connectionFrame
		 *            the unit implementation
		 * @return this so we can continue building
		 */
		public Builder setConnectionFrame(ClientConnectionUnit connectionFrame) {
			this.connectionFrame = connectionFrame;
			return this;
		}

		/**
		 * Build the client out of the given components. If no components are specified, the default
		 * ones are used.
		 * 
		 * @return the newly created Client object
		 */
		public Client build() {
			return new Client(this);
		}
	}

}
