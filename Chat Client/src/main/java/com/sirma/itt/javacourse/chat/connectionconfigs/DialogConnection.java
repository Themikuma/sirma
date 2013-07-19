package com.sirma.itt.javacourse.chat.connectionconfigs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sirma.itt.javacourse.chat.client.maincomponents.MainUnit;

public class DialogConnection extends JDialog implements ActionListener, ConnectionUnit {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 3256466009104642108L;
	private JTextField host = new JTextField();
	private JTextField userName = new JTextField();
	private JTextField port = new JTextField();
	private JLabel status = new JLabel();
	private JButton connectButton = new JButton("connect");
	private JButton cancelButton = new JButton("cancel");
	private MainUnit mainWindow;
	private ServerConnectionThread connectionListener;

	/**
	 * Getter method for status.
	 * 
	 * @return the status
	 */
	public JLabel getStatus() {
		return status;
	}

	/**
	 * Setter method for status.
	 * 
	 * @param status
	 *            the status to set
	 */
	public void setStatus(JLabel status) {
		this.status = status;
	}

	public DialogConnection(MainUnit parent) {
		this.mainWindow = parent;
	}

	@Override
	public void start() {
		setPreferredSize(new Dimension(300, 200));
		connectButton.addActionListener(this);
		cancelButton.addActionListener(this);
		connectButton.setActionCommand("connect");
		cancelButton.setActionCommand("cancel");
		setLayout(new BorderLayout(15, 15));
		JPanel contentPane = new JPanel(new GridLayout(0, 2));
		contentPane.add(new JLabel("Host:"));
		contentPane.add(host);
		contentPane.add(new JLabel("Username:"));
		contentPane.add(userName);
		contentPane.add(new JLabel("Port:"));
		contentPane.add(port);
		contentPane.add(connectButton);
		contentPane.add(cancelButton);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		add(contentPane, BorderLayout.CENTER);
		add(status, BorderLayout.NORTH);
		status.setHorizontalAlignment(SwingConstants.CENTER);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("cancel")) {
			mainWindow.stop();
			dispose();
		} else if (e.getActionCommand().equals("connect")) {
			tryConnect(host.getText(), userName.getText(), Integer.parseInt(port.getText()));
		}
	}

	@Override
	public void updateStatus(String status) {
		this.status.setText(status);
		if ("ok".equals(status)) {
			mainWindow.startListening(connectionListener.getServer());
			dispose();
		}
	}

	@Override
	public void tryConnect(String host, String username, int port) {
		status.setText("Connecting...");
		connectionListener = new ServerConnectionThread(host, username, port, this);
		Thread thread = new Thread(connectionListener);
		thread.start();

	}

}
