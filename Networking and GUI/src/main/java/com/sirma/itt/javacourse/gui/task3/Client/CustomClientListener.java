package com.sirma.itt.javacourse.gui.task3.Client;

import java.net.Socket;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.ClientListener;

/**
 * The runnable that connects to the server and listens for messages from him.
 * 
 * @author user
 */
public class CustomClientListener extends ClientListener {
	private JTextArea console;

	/**
	 * Setting up the host and console.
	 * 
	 * @param socket
	 *            the socket connection
	 * @param console
	 *            the console to which the client is going to write.
	 */
	public CustomClientListener(Socket socket, JTextArea console) {
		super(socket);
		this.console = console;
	}

	@Override
	public void onConnect() {
		console.append("Connected to " + getSocket().getInetAddress() + " on port"
				+ getSocket().getPort() + "\n");
	}

	@Override
	public void onMessageReceived(String message) {
		console.append(message + "\n");
		closeConnection();
		console.append("Connection closed");
	}

}
