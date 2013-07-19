package com.cit.chat.server;

import java.io.IOException;
import java.net.ServerSocket;

import com.sirma.itt.javacourse.chat.server.maincomponents.ServerWindow;
import com.sirma.itt.javacourse.chat.server.structures.Client;
import com.sirma.itt.javacourse.chat.sockets.SocketFinder;

public class ServerMainThread implements Runnable {

	private ServerSocket socket;
	private String host;
	private int port;
	private UsersManager usersManager;

	/**
	 * @param host
	 */
	public ServerMainThread(String host, int port, ServerWindow window) {
		super();
		this.host = host;
		this.port = port;
		usersManager = new UsersManager(window);
	}

	@Override
	public void run() {
		connect();
		waitForClients();

	}

	/**
	 * Find available port on the given host and start the server on it.
	 * 
	 * @param host
	 *            the host on which the server is going to be ran
	 */
	public void connect() {
		socket = SocketFinder.getAvailableServerSocket(host, port);
	}

	/**
	 * Wait for clients to connect.
	 */
	public void waitForClients() {

		while (true) {
			acceptClient();
		}

	}

	/**
	 * Accept the client.
	 */
	public void acceptClient() {
		try {
			Client client = new Client(socket.accept(), "default");
			Thread thread = new Thread(new ClientMessagesReadThread(client, usersManager));
			thread.start();
		} catch (IOException e) {
		}
	}
}
