package com.sirma.itt.javacourse.chat.client.maincomponents;

import com.sirma.itt.javacourse.chat.structures.Message;

/**
 * An example implementation of the {@link MainUnit}, that writes messages to the console.
 * 
 * @author user
 */
public class ConsoleClient extends MainUnit {

	@Override
	public void onUserAdded(String user) {
		System.out.println(user + " has joined");

	}

	@Override
	public void onUserRemoved(String user) {
		System.out.println(user + " has left");

	}

	@Override
	public void onListReloadRequest(String users) {
		System.out.println("List reloaded with " + users);

	}

	@Override
	public void onMessageAdded(Message message) {
		System.out.println(message.getSender() + " : " + message.getMessage());

	}

	@Override
	public void start() {
		startConnectionUnit();
		// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// String line;
		// try {
		// while ((line = reader.readLine()) != null) {
		// sendMessage(IClientMessages.CLIENT_MESSAGE + "|" + line);
		// }
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// disconnect();
	}

	@Override
	public void onServerStopped() {
		System.out.println("Server stopped.");
	}

}
