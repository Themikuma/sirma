package com.sirma.itt.javacourse.gui.task4.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

/**
 * The runnable object that is going to listen for messages from the server.
 * 
 * @author user
 */
public class ClientListener implements Runnable {
	private Socket socket;
	private JTextArea console;
	private String host;

	/**
	 * Set up the client.
	 * 
	 * @param client
	 *            the {@link Client} that is going to be updated.
	 */
	public ClientListener(String host, JTextArea console) {
		super();
		this.console = console;
		this.host = host;
	}

	@Override
	public void run() {
		connect(host);
		try {
			while (true) {
				waitForMessage();
			}
		} catch (IOException e) {
			console.append("The server has been stopped" + "\n");
		}

	}

	/**
	 * Find an available server to connect to.
	 */
	public void connect(String host) {
		socket = SocketFinder.getAvailableSocket(host, 7000, 7020);
		console.append("Connected to " + host + " on port" + socket.getPort() + "\n");
	}

	/**
	 * Wait for one message from the server.
	 * 
	 * @return the read message
	 * @throws IOException
	 *             if the server has been stopped
	 */
	public String waitForMessage() throws IOException {
		String line = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		line = reader.readLine();
		console.setText(console.getText() + line + "\n");

		return line;
	}

}
