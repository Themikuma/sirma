package com.sirma.itt.javacourse.gui.task6.Server;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;
import com.sirma.itt.javacourse.gui.task6.Mediator;

public class Server extends JFrame implements ActionListener {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private Mediator mediator = new Mediator();
	private DefaultListModel model = new DefaultListModel();
	private JList<String> channels = new JList<>(model);

	public Server() {
		setSize(400, 600);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		JPanel controlPane = new JPanel(new GridLayout(0, 3, 15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		JButton addChannel = new JButton("+");
		JButton removeChannel = new JButton("-");
		JButton sendSignal = new JButton("Send");
		addChannel.addActionListener(this);
		removeChannel.addActionListener(this);
		sendSignal.addActionListener(this);
		controlPane.add(addChannel);
		controlPane.add(removeChannel);
		controlPane.add(sendSignal);
		contentPane.add(channels, BorderLayout.CENTER);
		contentPane.add(controlPane, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void startListening() {
		serverSocket = SocketFinder.getAvailableServerSocket(7000, 7020);
		while (true) {
			// TODO CLOSE THE STREAMS SOMEWHERE !!!
			try {
				clientSocket = serverSocket.accept();
				Thread thread = new Thread(new ServerListener(this));
				thread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("+".equals(command)) {
			String channelName = JOptionPane.showInputDialog(null, "Enter the channel's ip: ");
			model.addElement(channelName);
			mediator.addChannel(channelName);

		} else if ("-".equals(command)) {
			model.remove(channels.getSelectedIndex());
		} else {
			mediator.sendMessage(channels.getSelectedValue(), "You have been selected");
		}

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

	/**
	 * Getter method for mediator.
	 * 
	 * @return the mediator
	 */
	public Mediator getMediator() {
		return mediator;
	}

	/**
	 * Setter method for mediator.
	 * 
	 * @param mediator
	 *            the mediator to set
	 */
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	/**
	 * Getter method for channels.
	 * 
	 * @return the channels
	 */
	public JList<String> getChannels() {
		return channels;
	}

	/**
	 * Setter method for channels.
	 * 
	 * @param channels
	 *            the channels to set
	 */
	public void setChannels(JList<String> channels) {
		this.channels = channels;
	}

	/**
	 * Getter method for model.
	 * 
	 * @return the model
	 */
	public DefaultListModel getModel() {
		return model;
	}

	/**
	 * Setter method for model.
	 * 
	 * @param model
	 *            the model to set
	 */
	public void setModel(DefaultListModel model) {
		this.model = model;
	}
}
