package com.sirma.itt.javacourse.chat.connectionconfigs;

import java.net.Socket;

import com.sirma.itt.javacourse.chat.messages.IClientMessages;
import com.sirma.itt.javacourse.chat.messages.IServerMessages;
import com.sirma.itt.javacourse.chat.sockets.SocketFinder;
import com.sirma.itt.javacourse.chat.structures.Server;

public class ServerConnectionThread implements Runnable {
	// TODO why use observer with only one observer ?
	private Server server;
	private String host;
	private String username;
	private String status;
	private ConnectionUnit connectionUnit;
	private int port;

	/**
	 * 
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

		Socket socket = SocketFinder.getAvailableSocket(host, port);
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

	public Server getServer() {
		return server;
	}

}
