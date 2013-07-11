package com.sirma.itt.javacourse.gui.task3.Client;

import java.net.Socket;

import com.sirma.itt.javacourse.gui.sockets.ClientListener;
import com.sirma.itt.javacourse.gui.sockets.Console;

/**
 * The runnable that connects to the server and listens for messages from him.
 * 
 * @author user
 */
public class CustomClientListener extends ClientListener {
	private Console console;

	/**
	 * Setting up the host and console.
	 * 
	 * @param socket
	 *            the socket connection
	 * @param console
	 *            the console to which the client is going to write.
	 */
	public CustomClientListener(Socket socket, Console console) {
		super(socket);
		this.console = console;
	}

	@Override
	public void onConnect() {
		console.appendLine("Connected to " + getSocket().getInetAddress() + " on port"
				+ getSocket().getPort());
	}

	@Override
	public void onMessageReceived(String message) {
		console.appendLine(message);
		closeConnection();
		console.appendLine("Connection closed");
	}

}
