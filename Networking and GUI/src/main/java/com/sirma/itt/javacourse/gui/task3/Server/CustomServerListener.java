package com.sirma.itt.javacourse.gui.task3.Server;

import java.net.ServerSocket;
import java.util.Date;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;
import com.sirma.itt.javacourse.gui.sockets.ServerListener;

/**
 * The runnable that is going to init the server and listen for clients.
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
		console.append("A client has connected" + "\n");
		sendMessage(client);

	}

	/**
	 * Send a message through the output stream of the connection socket and close the socket
	 * afterwards.
	 * 
	 * @param client
	 *            the client to which the server is going to send the message to
	 */
	private void sendMessage(ClientWrapper client) {
		client.sendMessage("Hello! " + new Date());
		console.append("Sent a message to the client" + "\n");
		client.closeConnection();
	}
}
