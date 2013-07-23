package com.sirma.itt.javacourse.chat.connectionconfigs;

import java.net.Socket;

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
	// TODO why use observer with only one observer ?
	private Server server;
	private String host;
	private String username;
	private ConnectionUnit connectionUnit;
	private int port;

	/**
	 * Setting up the host, username, port and {@link ConnectionUnit}.
	 * 
	 * @param host
	 *            the host to connect to
	 * @param userName
	 *            the username to try to connect with
	 * @param port
	 *            the port of the host
	 * @param connectionUnit
	 *            the {@link ConnectionUnit} that started this runnable
	 */
	public ServerConnectionThread(String host, String userName, int port,
			ConnectionUnit connectionUnit) {
		this.host = host;
		this.username = userName;
		this.port = port;
		this.connectionUnit = connectionUnit;
	}

	@Override
	public void run() {
		connectionUnit.updateStatus("Connecting...");
		Socket socket = SocketFinder.getAvailableSocket(host, port);
		String status;
		if (socket == null) {
			status = "Invalid host";
		} else {
			server = new Server(socket);
			server.sendMessage(IClientMessages.CONNECTION_ATTEMPT + "|" + username);
			String msg = server.getMessage();
			System.out.println(msg);
			if (IServerMessages.NICK_OK.toString().equals(msg)) {
				status = "ok";
			} else
				status = "Invalid nickname";
		}
		connectionUnit.updateStatus(status);
	}

	/**
	 * Getter method of the server.
	 * 
	 * @return the Server
	 */
	public Server getServer() {
		return server;
	}

}
