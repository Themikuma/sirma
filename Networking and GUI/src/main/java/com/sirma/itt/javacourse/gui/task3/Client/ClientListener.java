package com.sirma.itt.javacourse.gui.task3.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

public class ClientListener implements Runnable {
	private Socket socket;
	private JTextArea console;
	private String host;

	/**
	 * @param socket
	 * @param console
	 */
	public ClientListener(String host, JTextArea console) {
		super();
		this.console = console;
		this.host = host;
	}

	@Override
	public void run() {
		connect(host);
		waitForMessage();

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
	public String waitForMessage() {
		String line = null;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()))) {

			line = reader.readLine();
			console.setText(console.getText() + line + "\n");

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "No available server was found");
		} catch (IOException e) {
		}

		console.setText(console.getText() + "The connection has been terminated");
		return line;
	}

}
