package com.sirma.itt.javacourse.gui.task5.Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;
import com.sirma.itt.javacourse.gui.task5.Memento;
import com.sirma.itt.javacourse.gui.task5.Originator;

public class Client extends JFrame implements ActionListener, KeyListener {
	private JTextArea console = new JTextArea();
	private JTextField msgField = new JTextField();
	private List<Memento> states = new ArrayList<>();
	private Socket socket;
	private Originator originator = new Originator();
	private int index;

	public Client() {
		setSize(400, 600);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		JPanel messagePane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		JButton downloadBtn = new JButton("Send");
		downloadBtn.addActionListener(this);
		msgField.addKeyListener(this);
		messagePane.add(console, BorderLayout.CENTER);
		messagePane.add(msgField, BorderLayout.SOUTH);
		contentPane.add(messagePane, BorderLayout.CENTER);
		contentPane.add(downloadBtn, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		index++;
		states.add(originator.saveMemento(msgField.getText()));
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			writer.write(msgField.getText());
			writer.newLine();
			writer.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		msgField.setText("");

	}

	public void connect() {
		socket = SocketFinder.getAvailableSocket(7000, 7020);
		console.setText(console.getText() + "Connected to localhost:" + socket.getPort() + "\n");
		Thread clientListenerThread = new Thread(new ClientListener(this));
		clientListenerThread.start();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (index != 0)
				index--;
			msgField.setText(originator.restoreMemento(states.get(index)));
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (index != states.size() - 1)
				index++;
			msgField.setText(originator.restoreMemento(states.get(index)));
		}

	}
}
