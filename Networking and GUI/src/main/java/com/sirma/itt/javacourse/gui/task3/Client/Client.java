package com.sirma.itt.javacourse.gui.task3.Client;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

public class Client extends JFrame {
	private JTextArea console = new JTextArea();

	public Client() {
		setSize(300, 200);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		contentPane.add(console, BorderLayout.CENTER);
		setContentPane(contentPane);
		setVisible(true);
	}

	public void connect() {
		Socket socket = SocketFinder.getAvailableSocket(7000, 7020);
		console.setText(console.getText() + "Connected to localhost:" + socket.getPort() + "\n");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				console.setText(console.getText() + line + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		console.setText(console.getText() + "The connection has been terminated");

	}

}
