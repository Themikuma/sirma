package com.sirma.itt.javacourse.chat.client.threads;

import java.awt.Color;

import javax.swing.JLabel;

public class TextAnimationThread implements Runnable {
	private JLabel label;

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			try {
				synchronized (label) {

					label.wait();
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
