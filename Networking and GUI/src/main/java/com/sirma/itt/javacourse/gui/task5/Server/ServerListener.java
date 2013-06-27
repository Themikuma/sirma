package com.sirma.itt.javacourse.gui.task5.Server;

import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

public class ServerListener implements Runnable {
	private JTextArea console;
	private ServerSocket socket;
	private String host;

	/**
	 * @param server
	 */
	public ServerListener(String host, JTextArea console) {
		super();
		this.host = host;
		this.console = console;
	}

	@Override
	public void run() {
		connect(host);
		waitForClients();
	}

	public void connect(String host) {
		socket = SocketFinder.getAvailableServerSocket(host, 7000, 7020);
		console.append("Server started on " + host + " port " + socket.getLocalPort() + "\n");
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
	 * Listen for a client and accept it's connection.
	 */
	public void acceptClient() {
		try {
			Thread updateThread = new Thread(new ServerMessageListener(socket.accept(), console));
			console.append("A client has connected" + "\n");
			updateThread.setDaemon(true);
			updateThread.start();
		} catch (IOException e) {

		}
	}

}
