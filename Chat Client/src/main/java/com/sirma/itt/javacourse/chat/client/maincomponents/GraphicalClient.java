package com.sirma.itt.javacourse.chat.client.maincomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.cit.chat.client.MessageRenderer;
import com.cit.chat.client.ServerMessagesReadThread;
import com.sirma.itt.javacourse.chat.messages.IClientMessages;
import com.sirma.itt.javacourse.chat.structures.Message;
import com.sirma.itt.javacourse.chat.structures.Server;

public class GraphicalClient extends JFrame implements ActionListener, MainUnit, KeyListener {
	private DefaultListModel<Message> messageModel = new DefaultListModel<>();
	private JList<Message> console = new JList<Message>(messageModel);
	private JTextField messageField = new JTextField();
	private DefaultListModel<String> userListModel = new DefaultListModel<>();
	private ServerMessagesReadThread listener;

	private Server server;

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -7758850056548062247L;

	public void initUI() {

		setPreferredSize(new Dimension(700, 600));

		JPanel messagePane = new JPanel(new BorderLayout(15, 15));
		JList<String> userList = new JList<String>(userListModel);
		userList.setPreferredSize(new Dimension(50, 100));
		userList.setBackground(Color.gray);
		userList.setForeground(Color.white);
		JButton sendButton = new JButton("Send");
		messageField.addKeyListener(this);
		messagePane.add(messageField, BorderLayout.CENTER);
		messagePane.add(sendButton, BorderLayout.EAST);
		JPanel consolePane = new JPanel(new BorderLayout());
		consolePane.setBackground(console.getBackground());
		consolePane.add(console, BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(consolePane);
		console.setBackground(Color.white);
		console.setCellRenderer(new MessageRenderer());
		sendButton.addActionListener(this);
		add(scroll, BorderLayout.CENTER);
		add(userList, BorderLayout.EAST);
		add(messagePane, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pack();
		setVisible(true);

	}

	@Override
	public void start() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				initUI();

			}
		});
		// connection.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		server.sendMessage(IClientMessages.CLIENT_MESSAGE + "|" + messageField.getText());

	}

	public DefaultListModel<Message> getMessageModel() {
		return messageModel;
	}

	// TODO add memento
	@Override
	public void addUser(String user) {
		userListModel.addElement(user);

	}

	@Override
	public void removeUser(String user) {
		userListModel.removeElement(user);

	}

	@Override
	public void reloadList(String users) {
		for (String userName : users.split(","))
			userListModel.addElement(userName);

	}

	@Override
	public void addMessage(Message message) {
		messageModel.addElement(message);

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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			server.sendMessage(IClientMessages.CLIENT_MESSAGE + "|" + messageField.getText());
			messageField.setText("");
		}

	}

	@Override
	public void stop() {
		dispose();

	}

	@Override
	public void startListening(Server server) {
		this.server = server;
		listener = new ServerMessagesReadThread(server, this);
		Thread thread = new Thread(listener);
		thread.setDaemon(true);
		thread.start();

	}

}
