package com.cit.chat.client;

import java.util.Date;

import com.sirma.itt.javacourse.chat.client.maincomponents.MainUnit;
import com.sirma.itt.javacourse.chat.client.strategies.Decider;
import com.sirma.itt.javacourse.chat.structures.Message;
import com.sirma.itt.javacourse.chat.structures.Server;

public class ServerMessagesReadThread implements Runnable {

	private Server server;
	private MainUnit mainWindow;
	private Decider decider;

	/**
	 * Set the host.
	 * 
	 * @param host
	 *            the host to connect to
	 */
	public ServerMessagesReadThread(Server server, MainUnit mainWindow) {
		this.server = server;
		this.mainWindow = mainWindow;
		decider = new Decider(mainWindow);
	}

	@Override
	public void run() {
		System.out.println("Thread started");

		String msg;
		while ((msg = server.getMessage()) != null) {
			decider.decide(msg);
		}

		server.closeConnection();
		mainWindow.addMessage(new Message("The server has stopped", new Date(), "System"));
	}

}
