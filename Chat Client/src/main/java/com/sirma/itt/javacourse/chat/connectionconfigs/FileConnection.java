package com.sirma.itt.javacourse.chat.connectionconfigs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A file based implementation of the {@link ConnectionUnit}. Loads the info from a file.
 * 
 * @author user
 */
public class FileConnection extends ConnectionUnit {

	private String path;

	/**
	 * Sets up the path to the file.
	 * 
	 * @param path
	 *            path to the file.
	 */
	// TODO handle file errors.
	public FileConnection(String path) {
		this.path = path;

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
		tryConnect(splitConfig[0], splitConfig[1], splitConfig[2]);

	}

	@Override
	public void updateStatus(String status) {
		System.out.println(status);
		if ("ok".equals(status))
			getMainWindow().startListening(getConnectionListener().getServer());

	}

}
