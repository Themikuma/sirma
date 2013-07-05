package com.sirma.itt.javacourse.gui.task6.Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.ClientListener;

/**
 * Handles the connection to the server, sending and receiving messages.
 * 
 * @author user
 */
public class CustomClientListener extends ClientListener {
	private BufferedWriter writer;
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

	/**
	 * Send message to the server.
	 * 
	 * @param message
	 *            the message to send
	 */
	public void sendMessage(String message) {

		try {

			writer.write(message);
			writer.newLine();
			writer.flush();

		} catch (IOException e1) {
			console.append("The connection with the server has already been terminated\n");
		}

	}

	@Override
	public void onConnect() {
		console.append("Connected to " + getSocket().getInetAddress() + " on port"
				+ getSocket().getPort() + "\n");
		try {
			writer = new BufferedWriter(new OutputStreamWriter(getSocket().getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onMessageReceived(String message) {
		console.append(message + "\n");

	}
}
