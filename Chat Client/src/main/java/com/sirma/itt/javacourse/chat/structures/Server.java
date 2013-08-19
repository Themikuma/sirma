package com.sirma.itt.javacourse.chat.structures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.sirma.itt.javacourse.chat.client.main.Client;
import com.sirma.itt.javacourse.chat.threads.MessageSender;

/**
 * A wrapper object representing the server.
 * 
 * @author user
 */
public class Server {
	private final Socket socket;
	private final BufferedWriter writer;
	private final BufferedReader reader;
	private final MessageSender messager;
	private final Client client;
	private final Thread messagerThread;

	/**
	 * Setting up the socket with the already established connection to the server and the client
	 * for error logging.
	 * 
	 * @param socket
	 *            the socket
	 * @param client
	 *            the client
	 * @throws IOException
	 *             An I/O error occurred while trying to open the socket's streams
	 */
	public Server(Socket socket, Client client) throws IOException {
		this.client = client;
		this.socket = socket;
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		messager = new MessageSender(writer, client.getMainUnit());
		messagerThread = new Thread(messager);
		messagerThread.setName("Sending thread");
		messagerThread.start();
	}

	/**
	 * Add a message to the queue of messages if the message is not empty.
	 * 
	 * @param message
	 *            the message to add to the queue
	 */
	public void sendMessage(String message) {
		if (message.split("[|]").length > 1 && !socket.isClosed()) {
			messager.addMessage(message);
		}
	}

	/**
	 * Waits for a message from the server.
	 * 
	 * @return the received message
	 */
	public String getMessage() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Close the connection to the server.
	 */
	public void closeConnection() {
		if (!socket.isClosed())
			try {
				socket.close();
			} catch (IOException e) {
				client.getMainUnit().onError("connection");
			}
		messagerThread.interrupt();
	}

	/**
	 * Getter method for socket.
	 * 
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}
}
