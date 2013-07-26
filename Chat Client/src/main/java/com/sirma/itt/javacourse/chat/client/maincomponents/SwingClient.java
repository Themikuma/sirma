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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	private JList<String> userList = new JList<String>(userListModel);
	private List<Memento> states = new ArrayList<>();
	private int index;
	private Originator originator = new Originator();
	private JMenu connectMenu = new JMenu();
	private JMenu localeMenu = new JMenu();
	private JMenuItem connectItem = new JMenuItem();
	private JMenuItem disconnectItem = new JMenuItem();
	private JMenuItem englishItem = new JMenuItem();
	private JMenuItem bulgarianItem = new JMenuItem();
	private JButton sendButton = new JButton();

	private JFrame mainFrame = new JFrame();

	private ResourceBundle buttonsBundle;

	/**
	 * Comment for serialVersionUID.
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -7758850056548062247L;

	/**
	 * Init the UI. The UI is initiated in the EDT.
	 */
	private void initUI() {
		redrawButtons();
		mainFrame.setPreferredSize(new Dimension(700, 600));
		mainFrame.setTitle("Swing Client");

		JPanel messagePane = new JPanel(new BorderLayout(15, 15));
		userList.setBackground(Color.gray);
		userList.setForeground(Color.white);
		userList.setPrototypeCellValue("jjjggfgddfg");
		sendButton = new JButton(buttonsBundle.getString("send"));
		sendButton.setActionCommand("send");

		messageField.addKeyListener(this);
		messageField.setDocument(new MaxCharsDocument(200));

		JMenuBar menu = new JMenuBar();
		connectMenu.add(connectItem);
		connectMenu.add(disconnectItem);
		localeMenu.add(englishItem);
		localeMenu.add(bulgarianItem);

		englishItem.addActionListener(this);
		bulgarianItem.addActionListener(this);
		connectItem.addActionListener(this);
		disconnectItem.addActionListener(this);

		englishItem.setActionCommand("eng");
		bulgarianItem.setActionCommand("bg");
		connectItem.setActionCommand("con");
		disconnectItem.setActionCommand("discon");
		menu.add(connectMenu);
		menu.add(localeMenu);
		mainFrame.setJMenuBar(menu);

		messagePane.add(messageField, BorderLayout.CENTER);
		messagePane.add(sendButton, BorderLayout.EAST);
		JPanel consolePane = new JPanel(new BorderLayout());
		consolePane.setBackground(console.getBackground());
		consolePane.add(console, BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(consolePane);
		JScrollPane userListScroll = new JScrollPane(userList);
		console.setBackground(Color.white);
		console.setCellRenderer(new MessageRenderer());
		sendButton.addActionListener(this);
		mainFrame.add(scroll, BorderLayout.CENTER);
		mainFrame.add(userListScroll, BorderLayout.EAST);
		mainFrame.add(messagePane, BorderLayout.SOUTH);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		mainFrame.pack();
		mainFrame.setLocation(screenCentre.x - mainFrame.getHeight() / 2, screenCentre.y
				- mainFrame.getWidth() / 2);
		mainFrame.setVisible(true);

	}

	/**
	 * Reset the button's texts. Called when the locale is changed.
	 */
	public void redrawButtons() {
		connectMenu.setText(buttonsBundle.getString("connection"));
		localeMenu.setText(buttonsBundle.getString("language"));
		connectItem.setText(buttonsBundle.getString("connect"));
		disconnectItem.setText(buttonsBundle.getString("disconnect"));
		englishItem.setText(buttonsBundle.getString("english"));
		bulgarianItem.setText(buttonsBundle.getString("bulgarian"));
		sendButton.setText(buttonsBundle.getString("send"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("send".equals(command)) {
			send();
		} else if ("con".equals(command))
			startConnectionUnit();
		else if ("discon".equals(command))
			disconnect();
		else {
			if ("eng".equals(command))
				setLocale(getSupportedLocale(0));
			else if ("bg".equals(command))
				setLocale(getSupportedLocale(1));
			buttonsBundle = ResourceBundle.getBundle("ButtonsBundle", getCurrentLocale());
			redrawButtons();
		}
	}

	@Override
	public void onUserAdded(final String user) {
		logMessage(user + " has joined the room");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				userListModel.addElement(user);
			}
		});

	}

	@Override
	public void onUserRemoved(String user) {
		logMessage(user + " has left the room");
		userListModel.removeElement(user);

	}

	@Override
	public void onListReloadRequest(String users) {
		for (String userName : users.split(","))
			onUserAdded(userName);

	}

	@Override
	public void onMessageAdded(final Message message) {
		if (messageModel.size() == 20) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					messageModel.remove(0);

				}
			});
		}
		logMessage(message.getSender() + ":" + message.getMessage());
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				messageModel.addElement(message);
				console.ensureIndexIsVisible(messageModel.indexOf(messageModel.lastElement()));
			}
		});

	}

	/**
	 * Send the message from the messageField to the server and clear it.
	 */
	private void send() {
		states.add(originator.saveMemento(messageField.getText()));
		index = states.size();
		sendMessage(IClientMessages.CLIENT_MESSAGE + "|" + messageField.getText());
		messageField.setText("");
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
			send();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && index != 0) {
			index--;
			messageField.setText(originator.restoreMemento(states.get(index)));
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN && index != states.size() - 1) {
			index++;
			messageField.setText(originator.restoreMemento(states.get(index)));
		}

	}

	@Override
	public void start() {
		buttonsBundle = ResourceBundle.getBundle("ButtonsBundle", getSupportedLocale(1));
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				initUI();

			}
		});

	}

	@Override
	public void onServerStopped() {
		userListModel.removeAllElements();

	}

}
