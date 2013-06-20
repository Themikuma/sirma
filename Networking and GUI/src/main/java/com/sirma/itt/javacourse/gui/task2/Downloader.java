package com.sirma.itt.javacourse.gui.task2;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Downloader implements Runnable {
	DownloadAgent agent;

	/**
	 * @param agent
	 */
	public Downloader(DownloadAgent agent) {
		this.agent = agent;
	}

	@Override
	public void run() {
		agent.getProgressBar().setValue(0);
		URLConnection connection = null;
		byte[] buffer = new byte[10240];
		int size = 0;
		int contentLength = 0;
		int readBytes = 0;
		try {
			connection = new URL(agent.getUrl()).openConnection();
			contentLength = connection.getContentLength();

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (BufferedInputStream reader = new BufferedInputStream(connection.getInputStream());
				FileOutputStream output = new FileOutputStream(getFileName())) {
			while ((size = reader.read(buffer)) > 0) {
				output.write(buffer);
				readBytes += size;
				System.out.println("Read " + readBytes + " bytes from " + contentLength
						+ " so far.");
				agent.updateProgressBar(readBytes * 100 / contentLength);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private String getFileName() {
		return agent.getUrl().substring(agent.getUrl().lastIndexOf("/") + 1);
	}
}
