package com.sirma.itt.javacourse.gui.task6;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

import com.sirma.itt.javacourse.gui.sockets.Console;
import com.sirma.itt.javacourse.gui.sockets.SocketFinder;
import com.sirma.itt.javacourse.gui.task6.Client.CustomClientListener;
import com.sirma.itt.javacourse.gui.task6.Server.CustomServerListener;

/**
 * Testing the communication between server and client.
 * 
 * @author user
 */
public class CommunicationTest {

	/**
	 * Start a server and a client and test the received from the client messages.
	 * 
	 * @throws IOException
	 *             if the server has stopped and the clients are trying to wait for a message from
	 *             him
	 */
	@Test
	public void test() throws IOException {
		ServerSocket serverSocket = SocketFinder.getAvailableServerSocket("localhost", 7000, 7020);

		ChannelManager mediator = new ChannelManager();
		Console dummyConsole = new Console();

		CustomServerListener listener = new CustomServerListener(serverSocket, mediator);
		Thread serverThread = new Thread(listener);
		serverThread.start();

		Socket clientSocket = SocketFinder.getAvailableSocket("localhost", 7000, 7020);
		CustomClientListener client = new CustomClientListener(clientSocket, dummyConsole);
		client.connect();
		client.sendMessage("connect:asd");
		String dennyResult = client.waitForMessage();

		mediator.addChannel("asd");
		client.sendMessage("connect:asd");
		String successMessage = client.waitForMessage();

		mediator.sendMessage("asd", "hello");
		String result = client.waitForMessage();

		listener.stopServer();
		client.closeConnection();

		assertTrue("Channel does not exist".equals(dennyResult)
				&& "Succesfully joined channel".equals(successMessage) && "hello".equals(result));
	}

}
