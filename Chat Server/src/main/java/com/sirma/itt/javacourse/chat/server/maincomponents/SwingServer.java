package com.sirma.itt.javacourse.chat.server.maincomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * A graphical implementation of the {@link ServerWindow}.
 * 
 * @author user
 */
public class SwingServer extends ServerWindow implements ActionListener {

	private JTextArea console = new JTextArea();
	private JFrame frame = new JFrame();
	// TODO close button handling
	/**
	 * Comment for serialVersionUID.
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -4342026673924478849L;

	/**
	 * Init the UI. This is done on the EDT.
	 */
	public void initUI() {
		frame.setPreferredSize(new Dimension(300, 300));

		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(this);
		JScrollPane scroll = new JScrollPane(console);
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(closeButton, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		frame.pack();
		frame.setLocation(screenCentre.x - frame.getHeight() / 2, screenCentre.y - frame.getWidth()
				/ 2);
		frame.setVisible(true);
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
	public void onClientConnected(String client) {
		console.append(client + " has connected.\n");

	}

	@Override
	public void onClientDisconnected(String client) {
		console.append(client + " has disconnected.\n");

	}

	@Override
	public void stop() {
		frame.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		stop();

	}

}
