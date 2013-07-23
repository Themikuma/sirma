package com.cit.chat.server;

import java.io.IOException;
import java.net.ServerSocket;

import com.cit.chat.server.connectionconfigs.ConnectionUnit;
import com.sirma.itt.javacourse.chat.server.maincomponents.ServerWindow;
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
	private String host;
	private int port;
	private UsersManager usersManager;
	private ConnectionUnit connectionUnit;

	/**
	 * Setting up the host, port, window and serverWindow.
	 * 
	 * @param host
	 *            the host to connect to
	 * @param port
	 *            the port, opened on the specified host
	 * @param window
	 *            the connection unit
	 * @param serverWindow
	 *            the main unit
	 */
	public ServerMainThread(String host, int port, ConnectionUnit window, ServerWindow serverWindow) {
		super();
		this.host = host;
		this.port = port;
		connectionUnit = window;
		usersManager = new UsersManager(serverWindow);
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
		socket = SocketFinder.getAvailableServerSocket(host, port);
		String status;
		if (socket == null) {
			status = "Invalid host";
		} else {
			status = "ok";
		}
		connectionUnit.updateStatus(status);
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
