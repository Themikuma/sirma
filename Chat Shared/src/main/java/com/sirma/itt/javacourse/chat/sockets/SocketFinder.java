package com.sirma.itt.javacourse.chat.sockets;

import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
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
	 * @param host
	 *            the host to start the server on
	 * @param min
	 *            the starting port
	 * @param max
	 *            the ending port
	 * @return the found socket
	 */
	public static ServerSocket getAvailableServerSocket(String host, int port) {

		try {
			ServerSocket socket = new ServerSocket(port, 0, InetAddress.getByName(host));
			return socket;
		} catch (BindException e) {
			System.out.println("Port " + port + " is already in use.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Connects to an available socket at the given host in the given port range.
	 * 
	 * @param host
	 *            the host at which the server is
	 * @param min
	 *            the starting port
	 * @param max
	 *            the ending port
	 * @return the found socket
	 */
	public static Socket getAvailableSocket(String host, int port) {
		try {
			Socket socket = new Socket(host, port);
			return socket;
		} catch (BindException e) {
			System.out.println("Port " + port + " is not available.");
		} catch (IOException e) {

		}

		return null;
	}
}
