package com.sirma.itt.javacourse.chat.server.connectionconfigs;

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
import javax.swing.SwingUtilities;

/**
 * Graphical implementation of the {@link ConnectionUnit}.
 * 
 * @author user
 */
public class DialogConnection extends ConnectionUnit implements ActionListener {
	private JTextField portField;
	private JLabel status = new JLabel();

	private JDialog dialog = new JDialog();
	/**
	 * Comment for serialVersionUID.
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -5727905105138951096L;

	/**
	 * Init the UI. This is where the overriding of the start method is required. The UI is
	 * initiated in the EDT.
	 */
	private void initUI() {

		dialog.setPreferredSize(new Dimension(300, 200));
		dialog.setTitle("Connection");

		JPanel contentPane = new JPanel(new GridLayout(0, 2, 15, 15));
		portField = new JTextField();
		contentPane.add(new JLabel("Port"));
		contentPane.add(portField);

		JButton okButton = new JButton("Start");
		JButton cancelButton = new JButton("Cancel");

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
		dialog.setVisible(true);

	}

	@Override
	public void start() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				initUI();

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if ("Cancel".equals(e.getActionCommand())) {
			dialog.dispose();
		} else if ("Start".equals(e.getActionCommand())) {
			tryConnect(portField.getText());
		}

	}

	@Override
	public void connectionEstablished() {
		dialog.dispose();

	}

	@Override
	public void connectionFailed(String message) {
		this.status.setText(message);

	}

}
