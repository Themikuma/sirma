package com.sirma.itt.javacourse.gui.task6.Server;

import java.net.ServerSocket;

import javax.swing.DefaultListModel;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;
import com.sirma.itt.javacourse.gui.sockets.ServerListener;
import com.sirma.itt.javacourse.gui.task6.ChannelManager;

/**
 * Handles the connection of clients.
 * 
 * @author user
 */
public class CustomServerListener extends ServerListener {

	private ChannelManager mediator;
	private DefaultListModel<String> model;

	/**
	 * Setting up the host, mediator and model.
	 * 
	 * @param socket
	 *            the socket connection
	 * @param mediator
	 *            the mediator that handles messages
	 * @param model
	 *            the model of the list with the channels
	 */
	public CustomServerListener(ServerSocket socket, ChannelManager mediator,
			DefaultListModel<String> model) {
		super(socket);
		this.mediator = mediator;
		this.model = model;
	}

	@Override
	public void onClientConnect(ClientWrapper client) {
		Thread updateThread = new Thread(new ServerMessageListener(client, mediator, model));
		updateThread.setDaemon(true);
		updateThread.start();

	}

	@Override
	public void onConnect() {
		// TODO Auto-generated method stub

	}
}
