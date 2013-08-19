package com.sirma.itt.javacourse.chat.server.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Locale;

import com.sirma.itt.javacourse.chat.server.UsersManager;
import com.sirma.itt.javacourse.chat.server.connectionconfigs.DialogConnection;
import com.sirma.itt.javacourse.chat.server.connectionconfigs.ServerConnectionUnit;
import com.sirma.itt.javacourse.chat.server.maincomponents.ServerMainUnit;
import com.sirma.itt.javacourse.chat.server.maincomponents.SwingServer;
import com.sirma.itt.javacourse.chat.server.threads.ServerMainThread;

/**
 * The main class of the server. Contains all the necessary components to start.
 * 
 * @author user
 */
public class Server {
	private final ServerMainUnit mainUnit;
	private final ServerConnectionUnit connectionUnit;
	private ServerSocket server;
	private final Locale[] supported = { Locale.ENGLISH, new Locale("bg") };
	private Locale currentLocale = Locale.getDefault();
	private final UsersManager usersManager = new UsersManager();

	/**
	 * Setting up the main and connection units.
	 * 
	 * @param builder
	 *            the builder to use.
	 */
	public Server(ServerBuilder builder) {
		this.mainUnit = builder.mainWindow;
		this.connectionUnit = builder.connectionWindow;
		connectionUnit.setServer(this);
		mainUnit.setServer(this);
		mainUnit.start();
	}

	/**
	 * Checks if the server is currently running.
	 * 
	 * @return true if the socket is bound and not null, false otherwise
	 */
	public boolean isRunning() {
		if (server == null || server.isClosed())
			return false;
		return true;
	}

	/**
	 * Stops the socket.
	 * 
	 * @throws IOException
	 *             if an IO exception occurs while trying to close the socket
	 */
	public void stopServer() throws IOException {
		server.close();
	}

	/**
	 * Start a thread that will try starting a server on the specified port. the host to start on
	 * 
	 * @param port
	 *            the port
	 */
	public void startServer(String port) {
		int portInt;
		try {
			portInt = Integer.parseInt(port);
			Thread listeningThread = new Thread(new ServerMainThread(portInt, this));
			listeningThread.setDaemon(true);
			listeningThread.start();
		} catch (NumberFormatException e) {
			connectionUnit.connectionRefused("malformedPort");
		}

	}

	/**
	 * Getter method for mainUnit.
	 * 
	 * @return the mainUnit
	 */
	public ServerMainUnit getMainUnit() {
		return mainUnit;
	}

	/**
	 * Getter method for connectionUnit.
	 * 
	 * @return the connectionUnit
	 */
	public ServerConnectionUnit getConnectionUnit() {
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

	/**
	 * Getter method for usersManager.
	 * 
	 * @return the usersManager
	 */
	public UsersManager getUsersManager() {
		return usersManager;
	}

	/**
	 * Implementing the builder pattern as a static nested class in order to increase encapsulation.
	 * By default the builder uses a {@link SwingServer} and a {@link DialogConnection}. They can be
	 * changed in the builder via method chaining.
	 * 
	 * @author user
	 */
	public static class ServerBuilder {
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
			return new Server(this);
		}
	}

}
