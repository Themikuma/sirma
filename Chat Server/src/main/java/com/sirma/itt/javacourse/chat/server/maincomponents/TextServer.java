package com.sirma.itt.javacourse.chat.server.maincomponents;


public class TextServer implements ServerWindow {

	@Override
	public void connected(String client) {
		System.out.println(client + " has connected");

	}

	@Override
	public void disconnected(String client) {
		System.out.println(client + " has disconnected");

	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
