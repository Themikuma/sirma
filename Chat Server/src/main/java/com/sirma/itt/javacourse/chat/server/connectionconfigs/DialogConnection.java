package com.sirma.itt.javacourse.chat.server.connectionconfigs;

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

import com.sirma.itt.javacourse.chat.threads.TextAnimationThread;

/**
 * Graphical implementation of the {@link ServerConnectionUnit}.
 * 
 * @author user
 */
public final class DialogConnection extends ServerConnectionUnit implements ActionListener {
	private final JTextField portField = new JTextField();
	private final JLabel status = new JLabel();
	private final JLabel portLabel = new JLabel();
	private final JDialog dialog = new JDialog();
	private final JButton okButton = new JButton();
	private final JButton cancelButton = new JButton();
	private final TextAnimationThread labelAnimation = new TextAnimationThread(this.status);
	private ResourceBundle messagesBundle;
	private ResourceBundle labelsBundle;
	private ResourceBundle buttonsBundle;
	/**
	 * Comment for serialVersionUID.
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -5727905105138951096L;

	/**
	 * Initializing the user interface from the EDT and starting the thread that animates the status
	 * label. Called when constructing the {@link Server} object from the builder.
	 */
	public DialogConnection() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				initUI();

			}
		});
		Thread thread = new Thread(labelAnimation);
		thread.start();
	}

	/**
	 * Init the UI. This is where the overriding of the start method is required. The UI is
	 * initiated in the EDT.
	 */
	private void initUI() {

		dialog.setPreferredSize(new Dimension(300, 200));
		dialog.setTitle("Connection");

		JPanel contentPane = new JPanel(new GridLayout(0, 2, 15, 15));

		contentPane.add(portLabel);
		contentPane.add(portField);

		okButton.setActionCommand("ok");
		cancelButton.setActionCommand("cancel");

		okButton.addActionListener(this);
		cancelButton.addActionListener(this);

		contentPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		contentPane.add(okButton);
		contentPane.add(cancelButton);
		status.setHorizontalAlignment(SwingConstants.CENTER);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.add(status, BorderLayout.NORTH);
		dialog.add(contentPane, BorderLayout.CENTER);
		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		dialog.pack();
		dialog.setLocation(screenCentre.x - dialog.getHeight() / 2,
				screenCentre.y - dialog.getWidth() / 2);
	}

	/**
	 * Updates the text of the ui elements according to the chosen language.
	 */
	private void updateUI() {
		messagesBundle = ResourceBundle.getBundle("MessagesBundle", getCurrentLocale());
		labelsBundle = ResourceBundle.getBundle("LabelsBundle", getCurrentLocale());
		buttonsBundle = ResourceBundle.getBundle("ButtonsBundle", getCurrentLocale());
		portLabel.setText(labelsBundle.getString("port"));
		dialog.setTitle(labelsBundle.getString("connection"));
		okButton.setText(buttonsBundle.getString("start"));
		cancelButton.setText(buttonsBundle.getString("cancel"));
	}

	@Override
	public void start() {
		if (!getServer().isRunning()) {

			updateUI();
			dialog.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if ("cancel".equals(e.getActionCommand())) {
			dialog.setVisible(false);
		} else if ("ok".equals(e.getActionCommand())) {
			tryConnect(portField.getText());
		}

	}

	@Override
	public void connectionEstablished() {
		dialog.setVisible(false);
	}

	@Override
	public void connectionRefused(String arg0) {
		this.status.setText(messagesBundle.getString(arg0));
		synchronized (status) {
			status.notify();
		}

	}

}
