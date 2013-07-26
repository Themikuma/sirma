package com.sirma.itt.javacourse.chat.server.threads;

import java.io.IOException;
import java.net.ServerSocket;

import com.sirma.itt.javacourse.chat.server.UsersManager;
import com.sirma.itt.javacourse.chat.server.main.Server;
import com.sirma.itt.javacourse.chat.server.structures.Client;
import com.sirma.itt.javacourse.chat.sockets.SocketFinder;

/**
 * The main thread of the server which listens for clients and starts a separate thread for each
 * client connected.
 * 
 * @author user
 */
public class ServerMainThread implements Runnable {

	private ServerSocket socket;
	private int port;
	private UsersManager usersManager;
	private Server server;

	/**
	 * Setting up the host, port, window and serverWindow.
	 * 
	 * @param port
	 *            the port of the server
	 * @param server
	 *            the server object
	 */
	public ServerMainThread(int port, Server server) {
		super();
		this.port = port;
		this.server = server;
		usersManager = new UsersManager(server.getMainUnit());
	}

	@Override
	public void run() {
		connect();
		waitForClients();

	}

	/**
	 * Try to start a server on the specified host and port and send the appropriate status to the
	 * connection unit.
	 */
	public void connect() {
		socket = SocketFinder.getAvailableServerSocket(port);
		if (socket == null) {
			server.getConnectionUnit().connectionFailed("Invalid port");
		} else {
			server.getConnectionUnit().connectionEstablished();
			server.getMainUnit().start();
			server.getMainUnit().logMessage("Server started on localhost " + ":" + port);
		}

	}

	/**
	 * Wait for clients to connect.
	 */
	public void waitForClients() {
		while (!Thread.currentThread().isInterrupted()) {
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
