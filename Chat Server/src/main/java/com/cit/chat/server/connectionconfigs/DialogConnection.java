package com.cit.chat.server.connectionconfigs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.chat.server.maincomponents.ServerWindow;

public class DialogConnection extends JDialog implements ConnectionUnit {
	private JTextField hostField;
	private JTextField portField;
	private JLabel status;
	private ServerWindow mainWindow;
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -5727905105138951096L;

	/**
	 * @param mainWindow
	 */
	public DialogConnection(ServerWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
	}

	public void initUI() {

		setPreferredSize(new Dimension(200, 200));

		JPanel contentPane = new JPanel(new GridLayout(15, 15));
		hostField = new JTextField();
		portField = new JTextField();
		contentPane.add(new JLabel("Host"));
		contentPane.add(hostField);
		contentPane.add(new JLabel("Port"));
		contentPane.add(portField);

		JButton okButton = new JButton("Start");
		JButton cancelButton = new JButton("Cancel");

		contentPane.add(okButton);
		contentPane.add(cancelButton);

		add(status, BorderLayout.NORTH);
		add(contentPane, BorderLayout.CENTER);
		pack();
		setVisible(true);

	}

	@Override
	public void updateStatus(String status) {
		if ("ok".equals(status)) {

		} else
			this.status.setText(status);
	}

	@Override
	public void start() {
		initUI();

	}

	@Override
	public void tryConnect(String host, int port) {
		// TODO Auto-generated method stub

	}
}
