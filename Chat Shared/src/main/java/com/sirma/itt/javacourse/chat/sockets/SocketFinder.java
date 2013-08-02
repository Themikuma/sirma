package com.sirma.itt.javacourse.chat.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Providing basic functionality for finding server and client sockets with a specified host in a
 * specified port range.
 * 
 * @author user
 */
public final class SocketFinder {

	/**
	 * Private constructor disallowing the instantiation of the class.
	 */
	private SocketFinder() {

	}

	/**
	 * Starts an available server socket at the given host in the given port range.
	 * 
	 * @param port
	 *            the port
	 * @return the found socket
	 * @throws IOException
	 *             an exception if the port is taken
	 */
	public static ServerSocket getAvailableServerSocket(int port) throws IOException {

		ServerSocket socket = new ServerSocket(port);
		return socket;

	}

	/**
	 * Connects to an available socket at the given host in the given port range.
	 * 
	 * @param host
	 *            the host at which the server is
	 * @param port
	 *            the port
	 * @return the found socket
	 * @throws IOException
	 *             if the host or port are incorrect
	 */
	public static Socket getAvailableSocket(String host, int port) throws IOException {

		Socket socket = new Socket(host, port);
		return socket;

	}
}
