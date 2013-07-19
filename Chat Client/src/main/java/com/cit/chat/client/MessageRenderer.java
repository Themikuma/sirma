package com.cit.chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import com.sirma.itt.javacourse.chat.structures.Message;

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
		JLabel senderLabel = new JLabel(value.getSender());
		this.setBackground(Color.white);
		JLabel messageLabel = new JLabel();
		messageLabel.setMaximumSize(new Dimension(10, 200));
		messageLabel
				.setText("<html><p style=\"width:300px\">" + value.getMessage() + "</p></html>");
		senderLabel.setBackground(Color.darkGray);
		senderLabel.setForeground(Color.white);
		senderLabel.setOpaque(true);
		add(new JLabel(value.getDate().toString()), BorderLayout.EAST);
		add(messageLabel, BorderLayout.CENTER);
		add(senderLabel, BorderLayout.NORTH);
		if (isSelected) {
			setBackground(Color.lightGray);
		} else if (!isSelected) {
			setBackground(Color.white);
		}
		return this;
	}
}
