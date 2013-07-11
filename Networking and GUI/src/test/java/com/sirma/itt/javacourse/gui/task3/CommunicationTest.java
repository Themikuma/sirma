package com.sirma.itt.javacourse.gui.task3;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

import com.sirma.itt.javacourse.gui.sockets.Console;
import com.sirma.itt.javacourse.gui.sockets.SocketFinder;
import com.sirma.itt.javacourse.gui.task3.Client.CustomClientListener;
import com.sirma.itt.javacourse.gui.task3.Server.CustomServerListener;

/**
 * Testing the communication between client and server.
 * 
 * @author user
 */
public class CommunicationTest {

	/**
	 * Start a servera client, wait for the message from the server and compare it.
	 * 
	 * @throws IOException
	 *             if the server has stopped and the clients are trying to wait for a message from
	 *             him
	 * @throws InterruptedException
	 */
	@Test
	public void testClientConnection() throws IOException {
		Console dummyConsole = new Console();
		ServerSocket serverSocket = SocketFinder.getAvailableServerSocket("localhost", 7000, 7020);
		CustomServerListener listener = new CustomServerListener(serverSocket, dummyConsole);
		Thread serverThread = new Thread(listener);
		serverThread.start();
		Socket clientSocket = SocketFinder.getAvailableSocket("localhost", 7000, 7020);
		CustomClientListener client = new CustomClientListener(clientSocket, dummyConsole);
		client.connect();

		String msg = client.waitForMessage();
		listener.stopServer();
		client.closeConnection();
		assertTrue(msg.contains("Hello"));
	}
}
