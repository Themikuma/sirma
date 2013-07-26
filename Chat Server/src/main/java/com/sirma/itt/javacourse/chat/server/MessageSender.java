package com.sirma.itt.javacourse.chat.server;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {

				client.getWriter().write(messages.take());
				client.getWriter().newLine();
				client.getWriter().flush();
			} catch (IOException e) {
				// if (!GraphicsEnvironment.isHeadless())
				// JOptionPane.showMessageDialog(null,
				// "The connection to the server has been terminated");
				// else
				// System.out.println("The connection to the server has been terminated");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
