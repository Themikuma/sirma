package com.cit.chat.clientmain;

import com.sirma.itt.javacourse.chat.client.maincomponents.GraphicalClient;
import com.sirma.itt.javacourse.chat.client.maincomponents.MainUnit;
import com.sirma.itt.javacourse.chat.connectionconfigs.ConnectionUnit;
import com.sirma.itt.javacourse.chat.connectionconfigs.DialogConnection;

public class ClientStartClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MainUnit mainFrame = new GraphicalClient();
		ConnectionUnit connection = new DialogConnection(mainFrame);
		mainFrame.start();
		connection.start();

	}
}
