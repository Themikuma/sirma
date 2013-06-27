package com.sirma.itt.javacourse.gui.task3.Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

public class ServerListener implements Runnable {
	private ServerSocket socket;
	private String host;
	private JTextArea console;

	/**
	 * @param host
	 * @param console
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
			Socket client = socket.accept();
			console.append("A client has connected" + "\n");
			sendMessage(client);
		} catch (IOException e1) {
		}
	}

	/**
	 * Send a message through the output stream of the connection socket and close the socket
	 * afterwards.
	 */
	private void sendMessage(Socket client) {
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				client.getOutputStream()))) {

			writer.write("Hello! " + new Date());
			console.append("Sent a message to the client" + "\n");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
