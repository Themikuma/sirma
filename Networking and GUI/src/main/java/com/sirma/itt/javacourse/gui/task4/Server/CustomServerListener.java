package com.sirma.itt.javacourse.gui.task4.Server;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;
import com.sirma.itt.javacourse.gui.sockets.ServerListener;

/**
 * The runnable that is going to wait for clients to connect.
 * 
 * @author user
 */
public class CustomServerListener extends ServerListener {
	private JTextArea console;
	private List<ClientWrapper> clientList = new ArrayList<>();

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
		clientList.add(client);

		console.setText(console.getText() + "Client N" + clientList.size() + " has connected"
				+ "\n");
		Thread updateThread = new Thread(new ClientNotifier(clientList));
		updateThread.setDaemon(true);
		updateThread.start();

	}
}
