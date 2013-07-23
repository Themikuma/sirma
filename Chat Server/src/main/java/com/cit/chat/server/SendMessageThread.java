package com.cit.chat.server;

import com.sirma.itt.javacourse.chat.server.structures.Client;

/**
 * A runnable object that sends a single message.
 * 
 * @author user
 */
public class SendMessageThread implements Runnable {
	private Client user;
	private String message;

	/**
	 * Setting up the user and the message.
	 * 
	 * @param user
	 *            the user
	 * @param message
	 *            the message to be sent
	 */
	public SendMessageThread(Client user, String message) {
		this.user = user;
		this.message = message;
	}

	@Override
	public void run() {
		user.sendMessage(message);
	}
}
