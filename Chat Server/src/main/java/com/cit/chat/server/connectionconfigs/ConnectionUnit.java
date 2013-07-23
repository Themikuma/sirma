package com.cit.chat.server.connectionconfigs;

import com.cit.chat.server.ServerMainThread;
import com.sirma.itt.javacourse.chat.server.maincomponents.ServerWindow;

/**
 * Defines the behavior of all connection units.
 * 
 * @author user
 */
public abstract class ConnectionUnit {
	private ServerWindow mainWindow;

	/**
	 * The method called when connecting to the server.
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
	 * Start a thread that will try starting a server on the specified host and port.
	 * 
	 * @param host
	 *            the host to start on
	 * @param port
	 *            the port
	 */
	public void tryConnect(String host, int port) {
		Thread thread = new Thread(new ServerMainThread(host, port, this, getMainWindow()));
		thread.start();
	}

	/**
	 * Setter method of the window.
	 * 
	 * @param window
	 *            the ServerWindow
	 */
	public void setParrent(ServerWindow window) {
		this.mainWindow = window;
	}

	/**
	 * Getter method for mainWindow.
	 * 
	 * @return the mainWindow
	 */
	public ServerWindow getMainWindow() {
		return mainWindow;
	}
}
