package com.sirma.itt.javacourse.chat.threads;

import java.awt.Color;

import javax.swing.JLabel;

/**
 * The runnable that performs the animation on error messages. The thread that runs this object is
 * started only once. While the thread is not interrupted, it waits on the label to be notified to
 * animate it, otherwise waits.
 * 
 * @author user
 */
public class TextAnimationThread implements Runnable {
	private final JLabel label;

	/**
	 * Setting up the label that is going to be animated.
	 * 
	 * @param label
	 *            the label
	 */
	public TextAnimationThread(JLabel label) {
		this.label = label;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {

			for (int i = 255; i > 0; i--) {

				label.setForeground(new Color(i, 0, 0));

				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
				}

			}
			try {
				synchronized (label) {

					label.wait();
				}
			} catch (InterruptedException e1) {

			}
		}

	}

}
