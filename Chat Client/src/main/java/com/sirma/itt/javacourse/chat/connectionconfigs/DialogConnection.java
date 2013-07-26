package com.sirma.itt.javacourse.chat.connectionconfigs;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * A graphical implementation of the {@link ConnectionUnit}. Uses a {@link JDialog} to display
 * components.
 * 
 * @author user
 */
public class DialogConnection extends ConnectionUnit implements ActionListener {

	/**
	 * Called when the connection unit is created.Inits the ui in the EDT thread.
	 */
	public DialogConnection() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				initUI();
			}
		});
	}

	/**
	 * Comment for serialVersionUID.
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 3256466009104642108L;
	private JTextField host = new JTextField();
	private JTextField userName = new JTextField();
	private JTextField port = new JTextField();
	private JLabel status = new JLabel();
	private JLabel hostLabel = new JLabel();
	private JLabel portLabel = new JLabel();
	private JLabel usernameLabel = new JLabel();
	private JDialog dialog = new JDialog();
	private ResourceBundle buttonsBundle;
	private ResourceBundle labelsBundle;
	private JButton connectButton = new JButton();
	private JButton cancelButton = new JButton();

	/**
	 * Init the UI. This is where the overriding of the start method is required. The UI is
	 * initiated in the EDT.
	 */
	private void initUI() {

		dialog.setPreferredSize(new Dimension(300, 200));
		dialog.setTitle("Connection");
		connectButton.addActionListener(this);
		cancelButton.addActionListener(this);
		connectButton.setActionCommand("connect");
		cancelButton.setActionCommand("cancel");
		JPanel contentPane = new JPanel(new GridLayout(0, 2, 5, 5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		contentPane.add(hostLabel);
		contentPane.add(host);
		contentPane.add(usernameLabel);
		contentPane.add(userName);
		contentPane.add(portLabel);
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

	}

	/**
	 * Called when the UI is started and when the dialog is opened or closed.
	 */
	public void updateUI() {
		connectButton.setText(buttonsBundle.getString("connect"));
		cancelButton.setText(buttonsBundle.getString("cancel"));
		hostLabel.setText(labelsBundle.getString("host"));
		portLabel.setText(labelsBundle.getString("port"));
		usernameLabel.setText(labelsBundle.getString("username"));
		dialog.setTitle(labelsBundle.getString("dialog"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("cancel".equals(e.getActionCommand())) {
			dialog.dispose();
		} else if ("connect".equals(e.getActionCommand())) {
			connect(host.getText(), port.getText(), userName.getText());
		}
	}

	@Override
	public void connectionEstablished() {
		dialog.setVisible(false);

	}

	@Override
	public void connectionRefused(String error) {
		this.status.setText(error);

	}

	@Override
	public void start() {
		buttonsBundle = ResourceBundle.getBundle("ButtonsBundle", getCurrentLocale());
		labelsBundle = ResourceBundle.getBundle("LabelsBundle", getCurrentLocale());
		updateUI();
		dialog.setVisible(true);

	}

}
