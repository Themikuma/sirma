package com.sirma.itt.javacourse.gui.task2;

import javax.swing.SwingUtilities;

/**
 * An example use of the {@link DownloadAgent}.
 * 
 * @author user
 */
public final class DownloadAgentStarter {
	/**
	 * A private constructor disallowing the instantiation of this class.
	 */
	private DownloadAgentStarter() {

	}

	/**
	 * The main method of the class.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				DownloadAgent agent = new DownloadAgent();
			}
		});
	}

}
