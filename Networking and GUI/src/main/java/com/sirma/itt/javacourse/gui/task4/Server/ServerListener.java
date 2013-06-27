package com.sirma.itt.javacourse.gui.task4.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

public class ServerListener implements Runnable {
	private ServerSocket socket;
	private String host;
	private JTextArea console;
	private List<Socket> clientList;

	/**
	 * @param host
	 * @param console
	 */
	public ServerListener(String host, JTextArea console, List<Socket> clientList) {
		super();
		this.host = host;
		this.console = console;
		this.clientList = clientList;
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
			clientList.add(socket.accept());
			console.setText(console.getText() + "Client N" + clientList.size() + " has connected"
					+ "\n");
			Thread updateThread = new Thread(new ClientNotifier(clientList));
			updateThread.setDaemon(true);
			updateThread.start();
		} catch (IOException e) {

		}
	}

}
