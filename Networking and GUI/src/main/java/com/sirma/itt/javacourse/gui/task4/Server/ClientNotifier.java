package com.sirma.itt.javacourse.gui.task4.Server;

import java.util.List;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;

/**
 * The runnable that is going to handle message sending to all clients from the client list.
 * 
 * @author user
 */
public class ClientNotifier implements Runnable {
	private List<ClientWrapper> clientList;

	/**
	 * Setting up the client list.
	 * 
	 * @param clientList
	 *            the client list to be set.
	 */
	public ClientNotifier(List<ClientWrapper> clientList) {
		this.clientList = clientList;
	}

	@Override
	public void run() {
		for (int i = 0; i < clientList.size(); i++) {
			if (i < clientList.size() - 1)
				clientList.get(i).sendMessage("Client N " + clientList.size() + " has connected.");
			else
				clientList.get(i).sendMessage("You are client N " + clientList.size());
		}

	}
}
