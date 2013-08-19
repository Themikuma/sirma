package com.sirma.itt.javacourse.chat.server.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import com.sirma.itt.javacourse.chat.server.main.Server;
import com.sirma.itt.javacourse.chat.server.structures.Client;
import com.sirma.itt.javacourse.chat.sockets.SocketFinder;

/**
 * The main thread of the server which listens for clients and starts a separate thread for each
 * client connected.
 * 
 * @author user
 */
public final class ServerMainThread implements Runnable {

	private ServerSocket socket;
	private int port;
	private Server server;
	private int ind = 0;

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
	}

	@Override
	public void run() {
		connect();
	}

	/**
	 * Try to start a server on the specified host and port and send the appropriate status to the
	 * connection unit.
	 */
	private void connect() {
		try {
			socket = SocketFinder.getAvailableServerSocket(port);
			server.setServer(socket);
			server.getConnectionUnit().connectionEstablished();
			server.getMainUnit().onConnectionEstablished(Integer.toString(port));
			waitForClients();
		} catch (IllegalArgumentException e) {
			server.getConnectionUnit().connectionRefused("malformedPort");
		} catch (IOException e) {
			server.getConnectionUnit().connectionRefused("usedPort");
		}
	}

	/**
	 * Wait for clients to connect.
	 */
	private void waitForClients() {

		try {
			while (!Thread.currentThread().isInterrupted()) {
				Socket clientSocket = socket.accept();
				Thread thread = new Thread(new ClientMessagesReadThread(new Client(clientSocket,
						server), server));
				thread.setName("client thread" + ind);
				ind++;
				thread.start();
			}
		} catch (SocketException e) {
			server.getMainUnit().onConnectionClosed();
		} catch (IOException e) {
			server.getMainUnit().onError("clientStreams");
		}

	}
}
