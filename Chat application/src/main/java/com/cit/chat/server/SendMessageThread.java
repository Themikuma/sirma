package com.cit.chat.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import com.cit.chat.common.IServerMessages;

public class SendMessageThread implements Runnable {
	private List<Client> userList;
	private String message;

	public SendMessageThread(List<Client> userList, String message) {
		this.userList = userList;
		this.message = message;
	}

	@Override
	public void run() {
		for (Client user : userList) {

			try {
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(user.getSocket()
						.getOutputStream()));
				for (Client userInfo : userList) {
					writer.write(IServerMessages.CLIENT_CONNECTED + "|" + userInfo.getUsername());
					writer.newLine();
					writer.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
