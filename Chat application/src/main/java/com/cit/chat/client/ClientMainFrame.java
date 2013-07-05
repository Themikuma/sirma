package com.cit.chat.client;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ClientMainFrame extends JFrame {
	private JTextArea console = new JTextArea();
	private JTextField messageField = new JTextField();
	private DefaultListModel<String> userListModel = new DefaultListModel<>();
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -7758850056548062247L;

	public void initUI() {

		setSize(700, 600);

		JPanel messagePane = new JPanel(new BorderLayout(15, 15));

		JList<String> userList = new JList<String>(userListModel);
		userList.setBackground(Color.gray);
		JButton sendButton = new JButton("Send");

		messagePane.add(messageField, BorderLayout.CENTER);
		messagePane.add(sendButton, BorderLayout.EAST);

		add(console, BorderLayout.CENTER);
		add(userList, BorderLayout.EAST);
		add(messagePane, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void start() {
		final LoginForm login = new LoginForm(this);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				login.initUI();

			}
		});
		login.start();
	}

	/**
	 * Getter method for userListModel.
	 * 
	 * @return the userListModel
	 */
	public DefaultListModel<String> getUserListModel() {
		return userListModel;
	}

	/**
	 * Setter method for userListModel.
	 * 
	 * @param userListModel
	 *            the userListModel to set
	 */
	public void setUserListModel(DefaultListModel<String> userListModel) {
		this.userListModel = userListModel;
	}
}
