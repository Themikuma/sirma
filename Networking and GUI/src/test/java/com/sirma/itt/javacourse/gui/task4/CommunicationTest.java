package com.sirma.itt.javacourse.gui.task4;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import org.junit.Test;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;
import com.sirma.itt.javacourse.gui.task4.Client.CustomClientListener;
import com.sirma.itt.javacourse.gui.task4.Server.CustomServerListener;

/**
 * Testing the communication between server and client.
 * 
 * @author user
 */
public class CommunicationTest {

	/**
	 * Start a server and 2 clients and compare the messages they receive.
	 * 
	 * @throws IOException
	 *             if the server has stopped and the clients are trying to wait for a message from
	 *             him
	 */
	@Test
	public void test() throws IOException {
		JTextArea dummyConsole = new JTextArea();
		ServerSocket serverSocket = SocketFinder.getAvailableServerSocket("localhost", 7000, 7020);
		Socket clientSocket = SocketFinder.getAvailableSocket("localhost", 7000, 7020);
		Socket secondClientSocket = SocketFinder.getAvailableSocket("localhost", 7000, 7020);

		CustomServerListener listener = new CustomServerListener(serverSocket, dummyConsole);
		Thread serverThread = new Thread(listener);
		serverThread.start();

		CustomClientListener client = new CustomClientListener(clientSocket, dummyConsole);
		CustomClientListener secondClient = new CustomClientListener(secondClientSocket,
				dummyConsole);
		client.connect();
		String firstMessage = client.waitForMessage();
		secondClient.connect();

		String thirdMessage = secondClient.waitForMessage();
		String secondMessage = client.waitForMessage();
		listener.stopServer();
		client.closeConnection();
		secondClient.closeConnection();
		System.out.println(firstMessage + "\n" + secondMessage + "\n" + thirdMessage);
		assertTrue("You are client N 1".equals(firstMessage)
				&& "Client N 2 has connected.".equals(secondMessage)
				&& "You are client N 2".equals(thirdMessage));

	}
}
