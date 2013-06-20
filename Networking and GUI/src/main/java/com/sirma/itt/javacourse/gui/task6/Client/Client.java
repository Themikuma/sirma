package com.sirma.itt.javacourse.gui.task6.Client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

public class Client extends JFrame implements ActionListener {
	// TODO not a client socket
	private Socket socket;
	private JTextArea console = new JTextArea();

	public Client() {
		setSize(300, 400);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		JPanel buttonPane = new JPanel(new GridLayout(0, 1));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		JButton downloadBtn = new JButton("Connect");
		JButton closeBtn = new JButton("Close");
		downloadBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		contentPane.add(console, BorderLayout.CENTER);
		buttonPane.add(downloadBtn);
		buttonPane.add(closeBtn);
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void connect() {
		socket = SocketFinder.getAvailableSocket(7000, 7020);
		console.setText(console.getText() + "Connected to localhost:" + socket.getPort() + "\n");
		Thread thread = new Thread(new ClientListener(this));
		thread.start();

	}

	public void disconnect() {

		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			writer.write("disconnect");
			writer.newLine();
			writer.flush();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void connectToChannel(String channel) {
		try {
			setTitle(channel);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			writer.write("connect:" + channel);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("Connect".equals(command))
			connectToChannel(JOptionPane.showInputDialog(null, "Enter the channel's ip: "));
		else {
			disconnect();
		}

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

}
