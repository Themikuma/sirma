package com.sirma.itt.javacourse.gui.task5;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import org.junit.Test;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;
import com.sirma.itt.javacourse.gui.task5.Client.CustomClientListener;
import com.sirma.itt.javacourse.gui.task5.Server.CustomServerListener;

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

		ServerSocket serverSocket = SocketFinder.getAvailableServerSocket("localhost", 7000, 7020);
		Socket clientSocket = SocketFinder.getAvailableSocket("localhost", 7000, 7020);
		JTextArea dummyConsole = new JTextArea();
		CustomServerListener listener = new CustomServerListener(serverSocket, dummyConsole);
		Thread serverThread = new Thread(listener);
		serverThread.start();
		CustomClientListener client = new CustomClientListener(clientSocket, dummyConsole);
		CustomClientListener secondClient = new CustomClientListener(clientSocket, dummyConsole);
		client.connect();
		secondClient.connect();
		secondClient.sendMessage("Outline");
		client.sendMessage("hello");
		String result = client.waitForMessage();
		String secondResult = secondClient.waitForMessage();
		listener.stopServer();
		assertTrue("olleh".equals(result) && "eniltuO".equals(secondResult));

	}
}
