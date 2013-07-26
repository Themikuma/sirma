package com.sirma.itt.javacourse.chat.client.threads;

import java.net.Socket;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.messages.IClientMessages;
import com.sirma.itt.javacourse.chat.messages.IServerMessages;
import com.sirma.itt.javacourse.chat.sockets.SocketFinder;
import com.sirma.itt.javacourse.chat.structures.Server;

/**
 * The thread that tries to establish connection the server socket and send the username.
 * 
 * @author user
 */
public class ServerConnectionThread implements Runnable {
	private String host;
	private String username;
	private Client client;
	private int port;

	/**
	 * Setting up the host, username, port and Client.
	 * 
	 * @param host
	 *            the host to connect to
	 * @param userName
	 *            the username to try to connect with
	 * @param port
	 *            the port of the host
	 * @param client
	 *            the client mediator
	 */
	public ServerConnectionThread(String host, String userName, int port, Client client) {
		this.host = host;
		this.username = userName;
		this.port = port;
		this.client = client;
	}

	@Override
	public void run() {
		client.getConnectionUnit().connectionRefused("Connecting...");
		Socket socket = SocketFinder.getAvailableSocket(host, port);
		if (socket == null) {
			client.getConnectionUnit().connectionRefused("Invalid host");
		} else {
			Server server = new Server(socket, client);
			server.sendMessage(IClientMessages.CONNECTION_ATTEMPT + "|" + username);
			String msg = server.getMessage();
			if (IServerMessages.NICK_OK.toString().equals(msg)) {
				client.setConnected(true);
				client.setServer(server);
				client.getConnectionUnit().connectionEstablished();
				client.startListening();
			} else
				client.getConnectionUnit().connectionRefused("Invalid nickname");
		}

	}

}
