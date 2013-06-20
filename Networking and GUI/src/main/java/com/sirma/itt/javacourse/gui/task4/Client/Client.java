package com.sirma.itt.javacourse.gui.task4.Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

public class Client extends JFrame implements ActionListener {
	private JTextArea console = new JTextArea();
	private Socket socket;

	public Client() {
		setSize(300, 200);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		JButton downloadBtn = new JButton("Connect");
		downloadBtn.addActionListener(this);

		contentPane.add(console, BorderLayout.CENTER);
		contentPane.add(downloadBtn, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		socket = SocketFinder.getAvailableSocket(7000, 7020);
		console.setText(console.getText() + "Connected to localhost:" + socket.getPort() + "\n");
		Thread messageReceiver = new Thread(new ClientListener(this));
		messageReceiver.start();

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

	/**
	 * Getter method for socket.
	 * 
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * Setter method for socket.
	 * 
	 * @param socket
	 *            the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}
