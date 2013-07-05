package com.sirma.itt.javacourse.gui.task5.Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.ClientListener;
import com.sirma.itt.javacourse.gui.sockets.MessageSender;

/**
 * The runnable that is going to connect to the server, listen for and send messages.
 * 
 * @author user
 */
public class CustomClientListener extends ClientListener {

	private JTextArea console;
	private MessageSender messager;

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
	 * Sends the message to the server.
	 * 
	 * @param message
	 *            the message to send.
	 */
	public void sendMessage(String message) {
		messager.addMessage(message);

	}

	@Override
	public void onConnect() {
		console.append("Connected to " + getSocket().getInetAddress() + " on port"
				+ getSocket().getPort() + "\n");
		try {
			messager = new MessageSender(new BufferedWriter(new OutputStreamWriter(getSocket()
					.getOutputStream())));
			Thread thread = new Thread(messager);
			thread.start();
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
