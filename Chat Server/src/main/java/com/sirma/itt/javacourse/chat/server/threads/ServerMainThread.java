package com.sirma.itt.javacourse.chat.server.threads;

import java.io.IOException;
import java.net.ServerSocket;

import org.apache.log4j.Logger;

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
	private static final Logger logger = Logger.getLogger(ServerMainThread.class);

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
		usersManager = new UsersManager();
	}

	@Override
	public void run() {
		connect();
	}

	/**
	 * Try to start a server on the specified host and port and send the appropriate status to the
	 * connection unit.
	 */
	public void connect() {
		try {
			socket = SocketFinder.getAvailableServerSocket(port);
			server.setServer(socket);
			server.getConnectionUnit().connectionEstablished();
			server.getMainUnit().addMessage("Server",
					"Server started on " + server.getServer().getInetAddress() + ":" + port);
			waitForClients();
		} catch (IOException e) {
			server.getConnectionUnit().connectionRefused("Port already in use");
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

			Client client = new Client(socket.accept());
			System.out.println("client trying to connect");
			Thread thread = new Thread(new ClientMessagesReadThread(client, usersManager, server));
			thread.start();
		} catch (IOException e) {
			logger.error("An IO exception occured while trying to accept a client");
		}
	}
}
