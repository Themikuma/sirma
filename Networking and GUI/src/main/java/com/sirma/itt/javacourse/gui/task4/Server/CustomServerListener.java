package com.sirma.itt.javacourse.gui.task4.Server;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;
import com.sirma.itt.javacourse.gui.sockets.Console;
import com.sirma.itt.javacourse.gui.sockets.ServerListener;

/**
 * The runnable that is going to wait for clients to connect.
 * 
 * @author user
 */
public class CustomServerListener extends ServerListener {
	private Console console;
	private List<ClientWrapper> clientList = new ArrayList<>();
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
		clientList.add(client);
		console.appendLine("Client N" + clientList.size() + " has connected");
		threadPool.execute(new ClientNotifier(clientList));
	}
}
