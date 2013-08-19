package com.sirma.itt.javacourse.chat.client.maincomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

import com.sirma.itt.javacourse.chat.structures.Message;

/**
 * A {@link JPanel} determining how the fields of the {@link Message} object are going to be shown
 * in each cell of the JList.
 * 
 * @author user
 */
public class MessageRenderer extends JPanel implements ListCellRenderer<Message> {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 6250894054252616804L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Message> list, Message value,
			int index, boolean isSelected, boolean cellHasFocus) {
		this.removeAll();

		this.setLayout(new BorderLayout(15, 15));
		this.setBorder(BorderFactory.createLineBorder(Color.white));
		this.setBackground(Color.white);

		JLabel senderLabel = new JLabel(value.getSender());
		JLabel dateLabel = new JLabel(value.getDate(), SwingConstants.RIGHT);
		JTextArea messageLabel = new JTextArea();
		JPanel topPanel = new JPanel(new GridLayout(1, 2));

		dateLabel.setBackground(value.getColor());
		dateLabel.setOpaque(true);
		dateLabel.setForeground(Color.white);

		messageLabel.setWrapStyleWord(true);
		messageLabel.setLineWrap(true);
		messageLabel.setText(value.getMessage());
		messageLabel.setBackground(new Color(255, 255, 255, 0));

		senderLabel.setBackground(value.getColor());
		senderLabel.setForeground(Color.white);

		senderLabel.setOpaque(true);

		topPanel.add(senderLabel);
		topPanel.add(dateLabel);

		add(messageLabel, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);

		if (isSelected) {
			setBackground(Color.lightGray);
		} else if (!isSelected) {
			setBackground(Color.white);
		}

		return this;
	}
}
