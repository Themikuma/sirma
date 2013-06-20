package com.sirma.itt.javacourse.gui.task4.Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

public class ServerListener implements Runnable {
	private List<Socket> clientList;

	/**
	 * @param clientList
	 */
	public ServerListener(List<Socket> clientList) {
		this.clientList = clientList;
	}

	@Override
	public void run() {

		for (int i = 0; i < clientList.size(); i++) {
			try {
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientList.get(i)
						.getOutputStream()));
				if (i < clientList.size() - 1)
					writer.write("Client N " + clientList.size() + " has connected." + "\n");
				else
					writer.write("You are client N " + clientList.size() + "\n");

				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
