package com.sirma.itt.javacourse.chat.threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.Timer;

import com.sirma.itt.javacourse.chat.contracts.MainUnit;

/**
 * A runnable that will send messages when available.
 * 
 * @author user
 */
public class MessageSender implements Runnable, ActionListener {
	private final BlockingQueue<String> messages = new LinkedBlockingQueue<String>();
	private final BufferedWriter writer;
	private final MainUnit main;

	/**
	 * Set up the writer of the server to which the message is going to be sent and the client for
	 * error logging.
	 * 
	 * @param writer
	 *            the writer
	 * @param main
	 *            the client
	 */
	public MessageSender(BufferedWriter writer, MainUnit main) {
		super();
		this.writer = writer;
		this.main = main;
	}

	@Override
	public void run() {
		new Timer(10000, this).start();
		try {
			while (!Thread.interrupted()) {
				writer.write(messages.take());
				writer.newLine();
				writer.flush();
			}
		} catch (InterruptedException e) {
		} catch (IOException e) {
			main.onError("messageSendError");
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
