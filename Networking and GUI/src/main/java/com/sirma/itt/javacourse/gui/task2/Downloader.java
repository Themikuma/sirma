package com.sirma.itt.javacourse.gui.task2;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 * Holds the logic behind the user interface of the {@link DownloadAgent}.
 * 
 * @author user
 */
public class Downloader extends SwingWorker<Void, BigInteger> {

	private String link;
	private String saveFile;

	/**
	 * Setting the agent.
	 * 
	 * @param link
	 *            path to the file to be downloaded
	 * @param saveFile
	 *            the location of the file to be saved
	 */
	public Downloader(String link, String saveFile) {
		this.link = link;
		this.saveFile = saveFile;
	}

	@Override
	protected Void doInBackground() throws Exception {
		downloadFile();
		return null;
	}

	/**
	 * Download the file from the given path to the given destination.
	 * 
	 * @return the total number of bytes copied
	 */
	public BigInteger downloadFile() {
		URLConnection connection = null;
		try {
			connection = new URL(link).openConnection();
		} catch (MalformedURLException e1) {
			JOptionPane.showMessageDialog(null, "Invalid url format");
			return null;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "General I/O exception has occured");
			return null;
		}
		int contentLength = connection.getContentLength();

		try (BufferedInputStream reader = new BufferedInputStream(connection.getInputStream());
				FileOutputStream output = new FileOutputStream(saveFile)) {
			byte[] buffer = new byte[10240];
			int size = 0;
			BigInteger readBytes = new BigInteger("0");

			while ((size = reader.read(buffer)) > 0) {
				output.write(buffer, 0, size);
				readBytes = readBytes.add(new BigInteger(Integer.toString(size)));
				int progress = readBytes.multiply(BigInteger.valueOf(100))
						.divide(BigInteger.valueOf(contentLength)).intValue();
				setProgress(progress);
			}
			return readBytes;
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File can't be opened for some reason");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "A General I/O exception occured.");
		}
		return null;
	}
}
