package com.sirma.itt.javacourse.chat.connectionconfigs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.sirma.itt.javacourse.chat.client.maincomponents.MainUnit;
import com.sirma.itt.javacourse.chat.structures.Server;

public class FileConnection implements ConnectionUnit {
	private ServerConnectionThread connection;
	private Server server;
	private MainUnit mainWindow;
	private String path;

	public FileConnection(MainUnit mainWindow, String path) {
		this.mainWindow = mainWindow;
		this.path = path;

	}

	/**
	 * Getter method for server.
	 * 
	 * @return the server
	 */
	public Server getServer() {
		return server;
	}

	@Override
	public void start() {
		String config = null;
		try {
			config = Files.readAllLines(Paths.get(path), Charset.defaultCharset()).get(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] splitConfig = config.split("[|]");
		tryConnect(splitConfig[0], splitConfig[1], Integer.parseInt(splitConfig[2]));

	}

	@Override
	public void updateStatus(String status) {
		System.out.println(status);
		if ("ok".equals(status))
			mainWindow.startListening(connection.getServer());

	}

	@Override
	public void tryConnect(String host, String username, int port) {
		connection = new ServerConnectionThread(host, username, port, this);
		Thread thread = new Thread(connection);
		thread.start();

	}
}
