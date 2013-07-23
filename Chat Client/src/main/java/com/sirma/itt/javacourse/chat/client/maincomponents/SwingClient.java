package com.sirma.itt.javacourse.chat.client.maincomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.sirma.itt.javacourse.chat.messages.IClientMessages;
import com.sirma.itt.javacourse.chat.structures.Message;

/**
 * A graphical implementation of the {@link MainUnit}. Uses swing and a {@link JFrame} to display
 * components.
 * 
 * @author user
 */
public class SwingClient extends MainUnit implements ActionListener, KeyListener {
	private DefaultListModel<Message> messageModel = new DefaultListModel<>();
	private JList<Message> console = new JList<Message>(messageModel);
	private JTextField messageField = new JTextField();
	private DefaultListModel<String> userListModel = new DefaultListModel<>();
	// TODO nope
	private JFrame mainFrame = new JFrame();

	/**
	 * Comment for serialVersionUID.
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -7758850056548062247L;

	/**
	 * Init the UI. This is where the overriding of the start method is required. The UI is
	 * initiated in the EDT.
	 */
	public void initUI() {

		mainFrame.setPreferredSize(new Dimension(700, 600));

		JPanel messagePane = new JPanel(new BorderLayout(15, 15));
		JList<String> userList = new JList<String>(userListModel);
		userList.setPreferredSize(new Dimension(50, 100));
		userList.setBackground(Color.gray);
		userList.setForeground(Color.white);
		JButton sendButton = new JButton("Send");
		messageField.addKeyListener(this);
		messagePane.add(messageField, BorderLayout.CENTER);
		messagePane.add(sendButton, BorderLayout.EAST);
		JPanel consolePane = new JPanel(new BorderLayout());
		consolePane.setBackground(console.getBackground());
		consolePane.add(console, BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(consolePane);
		console.setBackground(Color.white);
		console.setCellRenderer(new MessageRenderer());
		sendButton.addActionListener(this);
		mainFrame.add(scroll, BorderLayout.CENTER);
		mainFrame.add(userList, BorderLayout.EAST);
		mainFrame.add(messagePane, BorderLayout.SOUTH);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		mainFrame.pack();
		mainFrame.setLocation(screenCentre.x - mainFrame.getHeight() / 2, screenCentre.y
				- mainFrame.getWidth() / 2);
		mainFrame.setVisible(true);

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
		getServer().sendMessage(IClientMessages.CLIENT_MESSAGE + "|" + messageField.getText());

	}

	// TODO add memento
	@Override
	public void onUserAdded(String user) {
		userListModel.addElement(user);

	}

	@Override
	public void onUserRemoved(String user) {
		userListModel.removeElement(user);

	}

	@Override
	public void onListReloadRequest(String users) {
		for (String userName : users.split(","))
			userListModel.addElement(userName);

	}

	@Override
	public void onMessageAdded(Message message) {
		messageModel.addElement(message);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			getServer().sendMessage(IClientMessages.CLIENT_MESSAGE + "|" + messageField.getText());
			messageField.setText("");
		}

	}

	@Override
	public void stop() {
		mainFrame.dispose();

	}

}
