package com.sirma.itt.javacourse.chat.server.connectionconfigs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * An example implementation of the Connection unit that reads the port from a file.
 * 
 * @author user
 */
public class FileConnection extends ServerConnectionUnit {

	private String path;

	/**
	 * Setting up the path of the file.
	 * 
	 * @param path
	 *            the path of the file
	 */
	public FileConnection(String path) {
		this.path = path;
	}

	@Override
	public void start() {
		try {
			String config = Files.readAllLines(Paths.get(path), Charset.defaultCharset()).get(0);
			tryConnect(config);
		} catch (IOException e) {
			connectionRefused("File not found");
		}
	}

	@Override
	public void connectionEstablished() {
	}

	@Override
	public void connectionRefused(String arg0) {
		System.out.println(arg0);

	}

}
