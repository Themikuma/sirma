package com.sirma.itt.javacourse.gui.task6.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ServerListener implements Runnable {

	private Server server;

	public ServerListener(Server server) {
		this.server = server;
	}

	@Override
	public void run() {
		try {
			BufferedReader clientInput = new BufferedReader(new InputStreamReader(server
					.getClientSocket().getInputStream()));
			BufferedWriter clientOutput = new BufferedWriter(new OutputStreamWriter(server
					.getClientSocket().getOutputStream()));
			String msg = null;
			while ((msg = clientInput.readLine()) != null) {
				System.out.println(msg);
				if ("disconnect".equals(msg)) {
					server.getMediator().removeUser(server.getClientSocket());
					break;
				} else {
					if (server.getModel().contains(msg.split(":")[1])) {
						clientOutput.write("Succesfully joined channel");
						server.getMediator().addUser(msg.split(":")[1], server.getClientSocket());

					} else
						clientOutput.write("Channel does not exist");

					clientOutput.newLine();
					clientOutput.flush();
				}

			}
			System.out.println("socket closed");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
