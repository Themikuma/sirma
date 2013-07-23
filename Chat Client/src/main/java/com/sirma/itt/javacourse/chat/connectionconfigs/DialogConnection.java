package com.sirma.itt.javacourse.chat.connectionconfigs;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * A graphical implementation of the {@link ConnectionUnit}. Uses a {@link JDialog} to display
 * components.
 * 
 * @author user
 */
public class DialogConnection extends ConnectionUnit implements ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 3256466009104642108L;
	private JTextField host = new JTextField();
	private JTextField userName = new JTextField();
	private JTextField port = new JTextField();
	private JLabel status = new JLabel();
	private JButton connectButton = new JButton("connect");
	private JButton cancelButton = new JButton("cancel");

	private JDialog dialog = new JDialog();

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

	@Override
	public void start() {
		dialog.setPreferredSize(new Dimension(300, 200));
		connectButton.addActionListener(this);
		cancelButton.addActionListener(this);
		connectButton.setActionCommand("connect");
		cancelButton.setActionCommand("cancel");
		JPanel contentPane = new JPanel(new GridLayout(0, 2, 5, 5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		contentPane.add(new JLabel("Host:"));
		contentPane.add(host);
		contentPane.add(new JLabel("Username:"));
		contentPane.add(userName);
		contentPane.add(new JLabel("Port:"));
		contentPane.add(port);
		contentPane.add(connectButton);
		contentPane.add(cancelButton);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.add(contentPane, BorderLayout.CENTER);
		dialog.add(status, BorderLayout.NORTH);
		status.setHorizontalAlignment(SwingConstants.CENTER);
		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		dialog.pack();
		dialog.setLocation(screenCentre.x - dialog.getHeight() / 2,
				screenCentre.y - dialog.getWidth() / 2);
		dialog.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("cancel".equals(e.getActionCommand())) {
			getMainWindow().stop();
			dialog.dispose();
		} else if ("connect".equals(e.getActionCommand())) {
			tryConnect(host.getText(), userName.getText(), port.getText());
		}
	}

	@Override
	public void updateStatus(String status) {
		this.status.setText(status);
		if ("ok".equals(status)) {
			getMainWindow().startListening(getConnectionListener().getServer());
			dialog.dispose();
		}
	}

}
