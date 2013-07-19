package com.cit.chat.server;

import com.sirma.itt.javacourse.chat.server.structures.Client;

public class SendMessageThread implements Runnable {
	private Client user;
	private String message;

	public SendMessageThread(Client user, String message) {
		this.user = user;
		this.message = message;
	}

	@Override
	public void run() {
		user.sendMessage(message);
	}
}
