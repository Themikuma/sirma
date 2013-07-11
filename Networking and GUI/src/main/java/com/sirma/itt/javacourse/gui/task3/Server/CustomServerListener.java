package com.sirma.itt.javacourse.gui.task3.Server;

import java.net.ServerSocket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;
import com.sirma.itt.javacourse.gui.sockets.Console;
import com.sirma.itt.javacourse.gui.sockets.ServerListener;

/**
 * The runnable that is going to init the server and listen for clients.
 * 
 * @author user
 */
public class CustomServerListener extends ServerListener {

	private Console console;
	private ExecutorService threadPool = Executors.newCachedThreadPool();

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
		console.appendLine("A client has connected");
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
		threadPool.execute(new ClientMessager(client, "Hello! " + new Date()));
		console.appendLine("Sent a message to the client");

	}
}
