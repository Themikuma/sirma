package com.cit.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import com.cit.chat.sockets.SocketFinder;

public class ServerMainThread implements Runnable {

	private ServerSocket socket;
	private String host;
	private JTextArea console;
	private List<Client> clientList = new ArrayList<>();

	/**
	 * @param host
	 */
	public ServerMainThread(String host, JTextArea console) {
		super();
		this.host = host;
		this.console = console;
	}

	@Override
	public void run() {
		connect(host);
		waitForClients();

	}

	/**
	 * Find available port on the given host and start the server on it.
	 * 
	 * @param host
	 *            the host on which the server is going to be ran
	 */
	public void connect(String host) {
		socket = SocketFinder.getAvailableServerSocket(host, 7000, 7020);
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
			Socket client = socket.accept();
			Thread thread = new Thread(new ClientMessagesReadThread(client, console, clientList));
			thread.start();
		} catch (IOException e) {
			// TODO auto
		}
	}
}
