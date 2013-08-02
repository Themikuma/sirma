package com.sirma.itt.javacourse.chat.server;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.server.structures.Client;

/**
 * A runnable that will send messages when available.
 * 
 * @author user
 */
public class MessageSender implements Runnable {
	// TODO nope
	private BlockingQueue<String> messages = new LinkedBlockingQueue<String>();
	private Client client;
	private static final Logger logger = Logger.getLogger(MessageSender.class);

	/**
	 * Set up the client to which the message is going to be sent.
	 * 
	 * @param client
	 *            the client
	 */
	public MessageSender(Client client) {
		super();
		this.client = client;
	}

	// TODO doesnt receive messages in the correct order.. or doesnt send them.
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				String message = messages.take();
				client.getWriter().write(message);
				client.getWriter().newLine();
				client.getWriter().flush();
			} catch (IOException e) {
				logger.error("A client has terminated the connection while trying to send a message to him");
			} catch (InterruptedException e) {
				logger.error("The message sending thread was interrupted while trying to send a message to a client");
			}
		}

	}

	/**
	 * Add a message to the queue to be sent.
	 * 
	 * @param message
	 *            the message to be added
	 */
	public void addMessage(String message) {
		messages.offer(message);
	}
}
