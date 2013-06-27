package com.sirma.itt.javacourse.gui.task4.Server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * The main window of the server.
 * 
 * @author user
 */
public class Server extends JFrame implements ActionListener {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -1434592263904383102L;
	private List<Socket> clientList = new ArrayList<>();
	private JTextArea console = new JTextArea();

	/**
	 * Setting up the size and components of the window.
	 */
	// TODO remove useless constructors
	public Server() {

	}

	public void initUI() {
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
		Thread thread = new Thread(new ServerListener(JOptionPane.showInputDialog("Enter host"),
				console, clientList));
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		dispose();

	}
}
