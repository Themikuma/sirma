package com.sirma.itt.javacourse.gui.sockets;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Interface of the server listeners.
 * 
 * @author user
 */
public abstract class ServerListener implements Runnable {

	private ServerSocket socket;

	/**
	 * Set up the socket connection.
	 * 
	 * @param socket
	 *            the socket
	 */
	public ServerListener(ServerSocket socket) {
		super();
		this.socket = socket;
	}

	/**
	 * Stops the server.
	 */
	public void stopServer() {
		try {
			socket.close();
		} catch (IOException e) {

		}
	}

	@Override
	public void run() {
		onConnect();
		waitForClients();

	}

	/**
	 * Wait for clients to connect.
	 */
	public void waitForClients() {

		while (!Thread.interrupted()) {
			acceptClient();
		}

	}

	/**
	 * Accept the client.
	 */
	public void acceptClient() {
		try {
			ClientWrapper client = new ClientWrapper(socket.accept());
			onClientConnect(client);
		} catch (IOException e) {

		}
	}

	/**
	 * Let the user handle what happens when the server is started.
	 */
	public abstract void onConnect();

	/**
	 * Let the user handle what happens when a client connects.
	 * 
	 * @param client
	 *            the client that connected
	 */
	public abstract void onClientConnect(ClientWrapper client);

	/**
	 * Getter method for socket.
	 * 
	 * @return the socket
	 */
	public ServerSocket getSocket() {
		return socket;
	}

	/**
	 * Setter method for socket.
	 * 
	 * @param socket
	 *            the socket to set
	 */
	public void setSocket(ServerSocket socket) {
		this.socket = socket;
	}

}
