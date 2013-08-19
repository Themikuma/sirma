package com.sirma.itt.javacourse.chat.connectionconfigs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A file based implementation of the {@link ClientConnectionUnit}. Loads the info from a file.
 * 
 * @author user
 */
public final class FileConnection extends ClientConnectionUnit {
	private final String path;

	/**
	 * Sets up the path to the file.
	 * 
	 * @param path
	 *            path to the file.
	 */
	public FileConnection(String path) {
		this.path = path;
	}

	@Override
	public void connectionEstablished() {
		System.out.println("ok");
	}

	@Override
	public void connectionRefused(String error) {
		System.out.println(error);

	}

	@Override
	public void start() {
		try {
			String config = Files.readAllLines(Paths.get(path), Charset.defaultCharset()).get(0);
			String[] splitConfig = config.split("[|]");
			connect(splitConfig[0], splitConfig[1], splitConfig[2]);
		} catch (IOException e) {
			connectionRefused("File not found");
		}
	}
}
