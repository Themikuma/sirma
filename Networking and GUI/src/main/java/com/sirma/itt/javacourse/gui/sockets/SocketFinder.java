package com.sirma.itt.javacourse.gui.sockets;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketFinder {
	public static ServerSocket getAvailableServerSocket(int min, int max) {
		for (int i = min; i < max; i++) {
			try {
				ServerSocket socket = new ServerSocket(i);
				return socket;
			} catch (BindException e) {
				System.out.println("Port " + i + " is already in use, trying to open another port");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Socket getAvailableSocket(int min, int max) {
		for (int i = min; i <= max; i++) {
			try {
				Socket socket = new Socket("localhost", i);
				return socket;
			} catch (BindException e) {
				System.out.println("Port " + i
						+ " is not available, trying to connect on another port.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
