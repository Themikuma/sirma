package com.sirma.itt.javacourse.chat.threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.Timer;

/**
 * A runnable that will send messages when available.
 * 
 * @author user
 */
public class MessageSender implements Runnable, ActionListener {
	private final BlockingQueue<String> messages = new LinkedBlockingQueue<String>();
	private final PrintWriter writer;

	/**
	 * Set up the writer of the server to which the message is going to be sent and the client for
	 * error logging.
	 * 
	 * @param writer
	 *            the writer
	 */
	public MessageSender(PrintWriter writer) {
		super();
		this.writer = writer;
	}

	@Override
	public void run() {
		new Timer(10000, this).start();
		try {
			while (!Thread.interrupted()) {
				writer.println(messages.take());
			}
		} catch (InterruptedException e) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		addMessage("beat");

	}
}
