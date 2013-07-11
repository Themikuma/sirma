package com.sirma.itt.javacourse.gui.task5.Server;

import java.io.IOException;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;
import com.sirma.itt.javacourse.gui.sockets.Console;

/**
 * The runnable that is going to listen for each client's messages and send them back reversed.
 * 
 * @author user
 */
public class ServerMessageListener implements Runnable {
	private ClientWrapper client;
	private Console console;

	/**
	 * setting up the socket and console.
	 * 
	 * @param client
	 *            the client connection
	 * @param console
	 *            the console which is going to be updated with the clients messages
	 */
	public ServerMessageListener(ClientWrapper client, Console console) {
		super();
		this.client = client;
		this.console = console;

	}

	@Override
	public void run() {
		String msg = null;
		try {
			while (!".".equals(msg)) {

				msg = readClientMessage();
				if (msg != null)
					sendReversedMessage(msg);

			}
			client.closeConnection();
		} catch (IOException e) {
			System.out.println("The client has terminated the conection");
		}
		console.appendLine(console.getText() + "Client thread destroyed");

	}

	/**
	 * Read an incomming message from the client.
	 * 
	 * @return the read message
	 * @throws IOException
	 *             if the client has terminated the connection
	 */
	private String readClientMessage() throws IOException {

		String msg = client.receiveMessage();
		console.appendLine(console.getText() + "Client: " + msg);
		return msg;

	}

	/**
	 * Send the reversed message back to the client.
	 * 
	 * @param message
	 *            the message that is going to reversed and sent back
	 */
	private void sendReversedMessage(String message) {
		console.appendLine(console.getText() + "Sending back to client reversed message");
		client.sendMessage(new StringBuilder(message).reverse().toString());

	}
}
