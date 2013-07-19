package com.sirma.itt.javacourse.chat.structures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Server {
	private Socket socket;
	private BufferedWriter writer;
	private BufferedReader reader;
	// TODO executor vs queue
	private MessageSender messager;

	public Server(Socket socket) {
		this.socket = socket;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		messager = new MessageSender(writer);
		Thread thread = new Thread(messager);
		thread.start();
	}

	public void sendMessage(String message) {

		if (message.split("[|]").length > 1) {
			System.out.println("sending " + message);
			messager.addMessage(message);
		}
	}

	public String getMessage() {
		try {
			return reader.readLine();
		} catch (IOException e) {

		}
		return null;
	}

	public void closeConnection() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
