package com.sirma.itt.javacourse.gui.task5.Server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

public class Server extends JFrame implements ActionListener {
	private JTextArea console = new JTextArea();
	private ServerSocket serverSocket;
	private Socket clientSocket;

	public Server() {
		setSize(300, 200);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		// TODO rename downloadBTN
		JButton downloadBtn = new JButton("Stop");
		downloadBtn.addActionListener(this);
		contentPane.add(console, BorderLayout.CENTER);
		contentPane.add(downloadBtn, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setVisible(true);
	}

	public void startListening() {
		serverSocket = SocketFinder.getAvailableServerSocket(7000, 7020);
		console.setText(console.getText() + "Server opened on localhost:"
				+ serverSocket.getLocalPort() + "\n");
		try {
			while (true) {
				// TODO CLOSE THE STREAMS SOMEWHERE !!!
				clientSocket = serverSocket.accept();
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
						clientSocket.getOutputStream()));
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				writer.write("Welcome client");
				writer.newLine();
				writer.flush();
				Thread clientThread = new Thread(new ServerListener(this));
				clientThread.start();

			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			serverSocket.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dispose();

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
	 * Getter method for serverSocket.
	 * 
	 * @return the serverSocket
	 */
	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	/**
	 * Setter method for serverSocket.
	 * 
	 * @param serverSocket
	 *            the serverSocket to set
	 */
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	/**
	 * Getter method for clientSocket.
	 * 
	 * @return the clientSocket
	 */
	public Socket getClientSocket() {
		return clientSocket;
	}

	/**
	 * Setter method for clientSocket.
	 * 
	 * @param clientSocket
	 *            the clientSocket to set
	 */
	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
}
