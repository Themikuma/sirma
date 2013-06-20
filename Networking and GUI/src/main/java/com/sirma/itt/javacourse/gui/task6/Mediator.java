package com.sirma.itt.javacourse.gui.task6;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Mediator {
	private Map<String, Set<Socket>> userList = new HashMap<>();

	public void addUser(String channelName, Socket user) {
		Set<Socket> users = userList.get(channelName);

		users.add(user);
		System.out.println(users);
	}

	public void addChannel(String channelName) {
		userList.put(channelName, new LinkedHashSet<Socket>());
	}

	public void removeUser(Socket user) {
		Collection<Set<Socket>> userLists = userList.values();
		for (Set<Socket> list : userLists) {
			list.remove(user);
		}
	}

	public void sendMessage(String channelName, String message) {
		Set<Socket> users = userList.get(channelName);
		for (Socket user : users) {

			try {
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
						user.getOutputStream()));
				writer.write(message);
				writer.newLine();
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
