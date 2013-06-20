package com.sirma.itt.javacourse.gui.task4.Server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

public class Server extends JFrame implements ActionListener {
	private List<Socket> clientList = new ArrayList<>();
	private JTextArea console = new JTextArea();
	private ServerSocket socket;

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
		socket = SocketFinder.getAvailableServerSocket(7000, 7020);
		console.setText(console.getText() + "Server opened on localhost:" + socket.getLocalPort()
				+ "\n");
		try {
			while (true) {
				clientList.add(socket.accept());
				console.setText(console.getText() + "Client N" + clientList.size()
						+ " has connected" + "\n");
				Thread updateThread = new Thread(new ServerListener(clientList));
				updateThread.start();
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			socket.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dispose();

	}
}
