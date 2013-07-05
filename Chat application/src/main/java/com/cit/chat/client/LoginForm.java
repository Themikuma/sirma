package com.cit.chat.client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cit.chat.common.IClientMessages;

public class LoginForm extends JDialog implements ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 5957423488553476112L;
	private JTextField hostField = new JTextField();
	private JTextField nicknameField = new JTextField();
	private ServerMessagesReadThread listener;
	private ClientMainFrame mainWindow;

	public LoginForm(ClientMainFrame mainWindow) {
		this.mainWindow = mainWindow;
	}

	public void initUI() {
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		JPanel infoPane = new JPanel(new GridLayout(0, 2, 15, 15));
		setSize(300, 200);

		infoPane.add(new JLabel("Host: ", SwingConstants.CENTER));
		infoPane.add(hostField);
		infoPane.add(new JLabel("Nickname: ", SwingConstants.CENTER));
		infoPane.add(nicknameField);

		infoPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		JButton connectButton = new JButton("Connect");
		connectButton.addActionListener(this);

		contentPane.add(infoPane, BorderLayout.CENTER);
		contentPane.add(connectButton, BorderLayout.SOUTH);

		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(contentPane);
		setVisible(true);
	}

	public void start() {
		listener = new ServerMessagesReadThread(hostField.getText(), this, mainWindow);
		Thread thread = new Thread(listener);
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listener.sendMessage(IClientMessages.CONNECTION_ATTEMPT + "|" + nicknameField.getText());
	}
}
