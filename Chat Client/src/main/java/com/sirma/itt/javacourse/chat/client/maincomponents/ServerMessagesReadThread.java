package com.sirma.itt.javacourse.chat.client.maincomponents;

import java.util.Date;

import com.sirma.itt.javacourse.chat.client.strategies.Decider;
import com.sirma.itt.javacourse.chat.structures.Message;
import com.sirma.itt.javacourse.chat.structures.Server;

/**
 * The thread that is going to listen for messages from the server. Once a message is received, it
 * is passed to the {@link Decider}.
 * 
 * @author user
 */
public class ServerMessagesReadThread implements Runnable {

	private Server server;
	private MainUnit mainWindow;
	private Decider decider;

	/**
	 * Setting up the server and the main unit.
	 * 
	 * @param server
	 *            the server to be set
	 * @param mainWindow
	 *            the main unit to be set.
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
		mainWindow.onMessageAdded(new Message("The server has stopped", new Date(), "System"));

	}

}
