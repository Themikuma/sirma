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

	/**
	 * Setting the agent.
	 * 
	 * @param agent
	 *            the agent that the runnable is going to manipulate.
	 */
	public Downloader(String link) {
		this.link = link;
	}

	@Override
	protected Void doInBackground() throws Exception {
		downloadFile(link, getFileName(link));
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void done() {
		// TODO Auto-generated method stub
		super.done();
	}

	/**
	 * Gets the name of the file from the path.
	 * 
	 * @param path
	 *            the full path to the file
	 * @return the name of the file from the path
	 */
	public String getFileName(String path) {
		return path.substring(path.lastIndexOf("/") + 1);
	}

	/**
	 * Download the file from the given path to the given destination.
	 * 
	 * @param path
	 *            the path from which the file is going to be downloaded. It can be either a local
	 *            file or an online one.
	 * @param destination
	 *            the destination to which the file is going to be copied/downloaded
	 * @return the total number of bytes copied
	 */
	public BigInteger downloadFile(String path, String destination) {
		URLConnection connection = null;
		try {
			connection = new URL(path).openConnection();
		} catch (MalformedURLException e1) {
			JOptionPane.showMessageDialog(null, "Invalid url format");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		int contentLength = connection.getContentLength();

		try (BufferedInputStream reader = new BufferedInputStream(connection.getInputStream());
				FileOutputStream output = new FileOutputStream("resources\\" + destination)) {
			byte[] buffer = new byte[10240];
			int size = 0;
			BigInteger readBytes = new BigInteger("0");

			while ((size = reader.read(buffer)) > 0) {
				output.write(buffer, 0, size);
				readBytes = readBytes.add(new BigInteger(Integer.toString(size)));
				System.out.println(readBytes.intValue()
						+ " are "
						+ readBytes.multiply(new BigInteger("100"))
								.divide(new BigInteger(Integer.toString(contentLength))).intValue()
						+ "% of " + contentLength);
				setProgress(readBytes.multiply(new BigInteger("100"))
						.divide(new BigInteger(Integer.toString(contentLength))).intValue());
			}
			return readBytes;
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File can't be opened for some reason");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
