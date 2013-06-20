package com.sirma.itt.javacourse.gui.task3.Server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

public class Server extends JFrame implements ActionListener {

	private JTextArea console = new JTextArea();
	private Socket client;

	public Server() {
		setSize(300, 200);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		JButton downloadBtn = new JButton("Stop");
		downloadBtn.addActionListener(this);
		contentPane.add(console, BorderLayout.CENTER);
		contentPane.add(downloadBtn, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void startListening() {
		ServerSocket socket = SocketFinder.getAvailableServerSocket(7000, 7020);
		console.setText(console.getText() + "Server opened on localhost:" + socket.getLocalPort()
				+ "\n");
		try {
			client = socket.accept();

			console.setText(console.getText() + "A client has connected" + "\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				client.getOutputStream()))) {

			writer.write("Hello! " + new Date());
			console.setText(console.getText() + "Sent a message to the client" + "\n");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			client.shutdownOutput();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		dispose();

	}
}
