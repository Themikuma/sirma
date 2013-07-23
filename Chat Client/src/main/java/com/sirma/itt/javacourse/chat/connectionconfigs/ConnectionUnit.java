package com.sirma.itt.javacourse.chat.connectionconfigs;

import com.sirma.itt.javacourse.chat.client.maincomponents.MainUnit;

/**
 * The structure of each connection unit. Defines behavior for connecting to the server.
 * 
 * @author user
 */
public abstract class ConnectionUnit {
	private ServerConnectionThread connectionListener;
	private MainUnit mainWindow;

	/**
	 * Method, called from the connection thread to display information about the connection to the
	 * server.
	 * 
	 * @param status
	 *            the status to be displayed
	 */
	public abstract void updateStatus(String status);

	/**
	 * Empty method. Not every connection unit requires some kind of configuration when starting so
	 * overriding is not forced.
	 */
	public void start() {
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
			connectionListener = new ServerConnectionThread(host, username, portInt, this);
			Thread thread = new Thread(connectionListener);
			thread.start();
		} catch (NumberFormatException e) {
			updateStatus("Invalid host");
		}

	}

	/**
	 * Setter method for window.
	 * 
	 * @param window
	 *            the MainUnit
	 */
	public void setParent(MainUnit window) {
		this.mainWindow = window;

	}

	/**
	 * Getter method for connectionListener.
	 * 
	 * @return the connectionListener
	 */
	public ServerConnectionThread getConnectionListener() {
		return connectionListener;
	}

	/**
	 * Getter method for mainWindow.
	 * 
	 * @return the mainWindow
	 */
	public MainUnit getMainWindow() {
		return mainWindow;
	}

}
