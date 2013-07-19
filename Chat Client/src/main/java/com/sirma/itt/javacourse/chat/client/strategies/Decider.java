package com.sirma.itt.javacourse.chat.client.strategies;

import java.util.Date;

import com.sirma.itt.javacourse.chat.client.maincomponents.MainUnit;
import com.sirma.itt.javacourse.chat.messages.IServerMessages;
import com.sirma.itt.javacourse.chat.structures.Message;

public class Decider {
	private MainUnit main;

	public Decider(MainUnit main) {
		this.main = main;
	}

	public void decide(String msg) {
		System.out.println(msg);

		String[] splitMessage = msg.split("[|]");
		if (IServerMessages.USER_LIST.toString().equals(splitMessage[0])) {
			main.reloadList(splitMessage[1]);
		} else if (IServerMessages.ADD_TO_LIST.toString().equals(splitMessage[0])) {
			main.addUser(splitMessage[1]);
			main.addMessage(new Message("The client " + splitMessage[1] + " has connected.",
					new Date(), "System"));
		} else if (IServerMessages.CLIENT_DISCONNECTED.toString().equals(splitMessage[0])) {
			main.removeUser(splitMessage[1]);
			main.addMessage(new Message("The client " + splitMessage[1] + " has disconnected.",
					new Date(), "System"));
		} else if (IServerMessages.MESSAGE.toString().equals(splitMessage[0])) {
			main.addMessage(new Message(splitMessage[2], new Date(), splitMessage[1]));
		}
	}
}
