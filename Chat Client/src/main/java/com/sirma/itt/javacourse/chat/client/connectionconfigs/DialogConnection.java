package com.sirma.itt.javacourse.chat.client.connectionconfigs;

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

import com.sirma.itt.javacourse.chat.client.maincomponents.MaxCharsDocument;
import com.sirma.itt.javacourse.chat.threads.TextAnimationThread;

/**
 * A graphical implementation of the {@link ClientConnectionUnit}. Uses a {@link JDialog} to display
 * components.
 * 
 * @author user
 */
public final class DialogConnection extends ClientConnectionUnit implements ActionListener {
	private final JTextField host = new JTextField();
	private final JTextField userName = new JTextField();
	private final JTextField port = new JTextField();
	private final JLabel status = new JLabel();
	private final JLabel hostLabel = new JLabel();
	private final JLabel portLabel = new JLabel();
	private final JLabel usernameLabel = new JLabel();
	private final JDialog dialog = new JDialog();
	private final JButton connectButton = new JButton();
	private final JButton cancelButton = new JButton();
	private final TextAnimationThread labelAnimation = new TextAnimationThread(this.status);

	private ResourceBundle messageBundle;
	private ResourceBundle buttonsBundle;
	private ResourceBundle labelsBundle;
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 3256466009104642108L;

	/**
	 * Called when the connection unit is created.Inits the ui in the EDT thread and starts the
	 * animation thread for the status label.
	 */
	public DialogConnection() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initUI();
			}
		});
		Thread thread = new Thread(labelAnimation);
		thread.setDaemon(true);
		thread.start();
	}

	/**
	 * Init the UI. This is where the overriding of the start method is required. The UI is
	 * initiated in the EDT.
	 */
	private void initUI() {

		dialog.setPreferredSize(new Dimension(300, 200));
		connectButton.addActionListener(this);
		cancelButton.addActionListener(this);
		connectButton.setActionCommand("connect");
		cancelButton.setActionCommand("cancel");
		userName.setDocument(new MaxCharsDocument(20));
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
	private void updateUI() {
		buttonsBundle = ResourceBundle.getBundle("ClientButtonsBundle", getCurrentLocale());
		labelsBundle = ResourceBundle.getBundle("ClientLabelsBundle", getCurrentLocale());
		messageBundle = ResourceBundle.getBundle("ClientMessagesBundle", getCurrentLocale());
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
			dialog.setVisible(false);
		} else if ("connect".equals(e.getActionCommand())) {
			connect(host.getText(), port.getText(), userName.getText());
		}
	}

	@Override
	public void connectionEstablished() {
		status.setText("");
		dialog.setVisible(false);

	}

	@Override
	public void connectionRefused(String error) {
		this.status.setText(messageBundle.getString(error));
		synchronized (status) {
			status.notify();
		}
	}

	@Override
	public void start() {
		if (!getClient().isConnected()) {
			updateUI();
			dialog.setVisible(true);
		}

	}

}
