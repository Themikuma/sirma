package com.cit.chat.server;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ServerMainFrame extends JFrame {

	private JTextArea console = new JTextArea();
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -4342026673924478849L;

	public void initUI() {
		setSize(300, 300);

		JButton closeButton = new JButton("Close");

		add(console, BorderLayout.CENTER);
		add(closeButton, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void start() {
		Thread thread = new Thread(new ServerMainThread(JOptionPane.showInputDialog("Host"),
				console));
		thread.start();
	}
}
