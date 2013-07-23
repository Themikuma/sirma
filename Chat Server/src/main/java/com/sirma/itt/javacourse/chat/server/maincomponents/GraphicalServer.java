package com.sirma.itt.javacourse.chat.server.maincomponents;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class GraphicalServer extends JFrame implements ServerWindow {

	private JTextArea console = new JTextArea();
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -4342026673924478849L;

	public void initUI() {
		setSize(300, 300);

		JButton closeButton = new JButton("Close");
		JScrollPane scroll = new JScrollPane(console);
		add(scroll, BorderLayout.CENTER);
		add(closeButton, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void start() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				initUI();

			}
		});

	}

	/**
	 * Getter method for console.
	 * 
	 * @return the console
	 */
	public JTextArea getConsole() {
		return console;
	}

	/**
	 * Setter method for console.
	 * 
	 * @param console
	 *            the console to set
	 */
	public void setConsole(JTextArea console) {
		this.console = console;
	}

	@Override
	public void connected(String client) {
		console.append(client + " has connected.\n");

	}

	@Override
	public void disconnected(String client) {
		console.append(client + " has disconnected.\n");

	}

	@Override
	public void stop() {
		dispose();

	}

}
