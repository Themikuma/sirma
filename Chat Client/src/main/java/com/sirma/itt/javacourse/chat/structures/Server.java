package com.sirma.itt.javacourse.chat.structures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * A wrapper object representing the server.
 * 
 * @author user
 */
public class Server {
	private Socket socket;
	private BufferedWriter writer;
	private BufferedReader reader;
	private MessageSender messager;
	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Setting up the socket with the already established connection to the server.
	 * 
	 * @param socket
	 *            the socket
	 */
	public Server(Socket socket) {
		this.socket = socket;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			logger.error("An I/O error occured while trying to open the connection's ports");
		}
		messager = new MessageSender(writer);
		Thread thread = new Thread(messager);
		thread.start();
	}

	/**
	 * Add a message to the queue of messages if the message is not empty.
	 * 
	 * @param message
	 *            the message to add to the queue
	 */
	public void sendMessage(String message) {
		// TODO it still says connecting...
		if (message.split("[|]").length > 1) {
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
		try {
			socket.close();
		} catch (IOException e) {
			logger.error("An I/O error occured while trying to disconnect from the server");
		}
	}
}
