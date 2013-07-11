package com.sirma.itt.javacourse.gui.task4.Client;

import java.net.Socket;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.gui.sockets.ClientListener;
import com.sirma.itt.javacourse.gui.sockets.Console;

/**
 * The runnable object that is going to listen for messages from the server.
 * 
 * @author user
 */
public class CustomClientListener extends ClientListener {
	private Console console;
	private Logger logger = Logger.getLogger(this.getClass());

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
		System.out.println(logger.getName());
		console.appendLine("Connected to " + getSocket().getInetAddress() + " on port"
				+ getSocket().getPort());

	}

	@Override
	public void onMessageReceived(String message) {
		console.appendLine("massage received:" + message);
		logger.info(message);

	}

}
