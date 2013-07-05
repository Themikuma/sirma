package com.sirma.itt.javacourse.gui.task3.Client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

/**
 * The main window of the client.
 * 
 * @author user
 */
public class Client extends JFrame {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 4812376091391793740L;
	private JTextArea console = new JTextArea();

	/**
	 * Setting up the size and components of the client window.
	 */
	public void initUI() {
		setPreferredSize(new Dimension(300, 200));
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		contentPane.add(console, BorderLayout.CENTER);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		pack();
		setLocation(screenCentre.x - getHeight() / 2, screenCentre.y - getWidth() / 2);
		setVisible(true);
	}

	/**
	 * Start a new {@link CustomClientListener} thread.
	 */
	public void startListening() {
		Socket socket;
		setEnabled(false);
		while ((socket = SocketFinder.getAvailableSocket(JOptionPane.showInputDialog("host"), 7000,
				7020)) == null) {
		}
		setEnabled(true);
		Thread thread = new Thread(new CustomClientListener(socket, console));
		thread.setDaemon(true);
		thread.start();
	}
}
