package com.sirma.itt.javacourse.chat.client.maincomponents;

import com.cit.chat.client.ServerMessagesReadThread;
import com.sirma.itt.javacourse.chat.structures.Message;
import com.sirma.itt.javacourse.chat.structures.Server;

public class TextClient implements MainUnit {
	private ServerMessagesReadThread listener;
	private Server server;

	@Override
	public void addUser(String user) {
		System.out.println(user + " has joined");

	}

	@Override
	public void removeUser(String user) {
		System.out.println(user + " has left");

	}

	@Override
	public void reloadList(String users) {
		System.out.println("List reloaded with " + users);

	}

	@Override
	public void addMessage(Message message) {
		System.out.println(message.getSender() + " : " + message.getMessage());

	}

	@Override
	public void startListening(Server server) {
		this.server = server;
		listener = new ServerMessagesReadThread(server, this);
		Thread thread = new Thread(listener);
		thread.start();

	}

	@Override
	public void stop() {

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}
}
