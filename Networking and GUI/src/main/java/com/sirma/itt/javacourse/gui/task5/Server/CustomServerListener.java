package com.sirma.itt.javacourse.gui.task5.Server;

import java.net.ServerSocket;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;
import com.sirma.itt.javacourse.gui.sockets.ServerListener;

/**
 * The runnable that is going to listen for clients connections.
 * 
 * @author user
 */
public class CustomServerListener extends ServerListener {
	private JTextArea console;

	/**
	 * @param socket
	 *            the socket connection
	 * @param console
	 *            the console to which the server is going to write the received messages
	 */
	public CustomServerListener(ServerSocket socket, JTextArea console) {
		super(socket);
		this.console = console;
	}

	@Override
	public void onConnect() {
		console.append("Server started on " + getSocket().getInetAddress() + " port "
				+ getSocket().getLocalPort() + "\n");

	}

	@Override
	public void onClientConnect(ClientWrapper client) {
		Thread updateThread = new Thread(new ServerMessageListener(client, console));
		console.append("A client has connected" + "\n");
		updateThread.setDaemon(true);
		updateThread.start();

	}

}
