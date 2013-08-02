package com.sirma.itt.javacourse.chat.structures;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

/**
 * A runnable that will send messages when available.
 * 
 * @author user
 */
public class MessageSender implements Runnable {
	private BlockingQueue<String> messages = new LinkedBlockingQueue<String>();
	private BufferedWriter writer;
	private static final Logger logger = Logger.getLogger(MessageSender.class);

	/**
	 * Set up the writer of the server to which the message is going to be sent.
	 * 
	 * @param writer
	 *            the writer
	 */
	public MessageSender(BufferedWriter writer) {
		super();
		this.writer = writer;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				writer.write(messages.take());
				writer.newLine();
				writer.flush();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				logger.error("No active connection found while trying to send a message");
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
