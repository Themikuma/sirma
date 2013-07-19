package com.sirma.itt.javacourse.chat.structures;

import java.awt.GraphicsEnvironment;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JOptionPane;

/**
 * A runnable that will send messages when available.
 * 
 * @author user
 */
public class MessageSender implements Runnable {
	private BlockingQueue<String> messages = new LinkedBlockingQueue<String>();
	private BufferedWriter writer;

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
		while (!Thread.interrupted()) {
			try {
				writer.write(messages.take());
				writer.newLine();
				writer.flush();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				if (!GraphicsEnvironment.isHeadless())
					JOptionPane.showMessageDialog(null,
							"The connection to the server has been terminated");
				else
					System.out.println("The connection to the server has been terminated");
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
		messages.add(message);
	}
}
