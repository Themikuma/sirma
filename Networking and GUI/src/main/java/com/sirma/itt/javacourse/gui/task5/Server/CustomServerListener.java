package com.sirma.itt.javacourse.gui.task5.Server;

import java.net.ServerSocket;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;
import com.sirma.itt.javacourse.gui.sockets.Console;
import com.sirma.itt.javacourse.gui.sockets.ServerListener;

/**
 * The runnable that is going to listen for clients connections.
 * 
 * @author user
 */
public class CustomServerListener extends ServerListener {
	private Console console;

	/**
	 * @param socket
	 *            the socket connection
	 * @param console
	 *            the console to which the server is going to write the received messages
	 */
	public CustomServerListener(ServerSocket socket, Console console) {
		super(socket);
		this.console = console;
	}

	@Override
	public void onConnect() {
		console.appendLine("Server started on " + getSocket().getInetAddress() + " port "
				+ getSocket().getLocalPort());

	}

	@Override
	public void onClientConnect(ClientWrapper client) {
		Thread updateThread = new Thread(new ServerMessageListener(client, console));
		console.appendLine("A client has connected");
		updateThread.setDaemon(true);
		updateThread.start();

	}

}
