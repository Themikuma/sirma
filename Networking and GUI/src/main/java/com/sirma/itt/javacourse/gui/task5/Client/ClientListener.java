package com.sirma.itt.javacourse.gui.task5.Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

public class ClientListener implements Runnable {

	private String host;
	private JTextArea console;
	private Socket socket;

	/**
	 * @param client
	 */
	public ClientListener(String host, JTextArea console) {
		this.host = host;
		this.console = console;
	}

	@Override
	public void run() {

		connect(host);
		try {
			while (waitForMessage() != null) {
			}
		} catch (IOException e) {
			console.append("The server has been stopped" + "\n");
			return;
		}
		console.append("The connection has been terminated by the server\n");
	}

	/**
	 * Find an available server to connect to.
	 */
	public void connect(String host) {
		socket = SocketFinder.getAvailableSocket(host, 7000, 7020);
		console.append("Connected to " + host + " on port" + socket.getPort() + "\n");
	}

	/**
	 * Wait for a message from the server.
	 * 
	 * @return the received message
	 */
	public String waitForMessage() throws IOException {
		String line = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		line = reader.readLine();
		console.setText(console.getText() + line + "\n");

		return line;
	}

	/**
	 * Sends the message to the server.
	 * 
	 * @param message
	 *            the message to send.
	 */
	public void sendMessage(String message) {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			writer.write(message);
			writer.newLine();
			writer.flush();
		} catch (IOException e1) {
			console.append("The connection to the server has already been terminated\n");
		}

	}
}
