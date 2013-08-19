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
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.structures.Message;

/**
 * A graphical implementation of the {@link ClientMainUnit}. Uses swing and a {@link JFrame} to
 * display components.
 * 
 * @author user
 */
public final class SwingClient extends ClientMainUnit implements ActionListener, KeyListener {
	private final DefaultListModel<Message> messageModel = new DefaultListModel<>();
	private final JList<Message> console = new JList<Message>(messageModel);
	private final JTextField messageField = new JTextField();
	private final DefaultListModel<String> userListModel = new DefaultListModel<>();
	private final JList<String> userList = new JList<String>(userListModel);
	private final List<Memento> states = new ArrayList<>();
	private final Originator originator = new Originator();
	private final JMenu connectMenu = new JMenu();
	private final JMenu localeMenu = new JMenu();
	private final JMenuItem connectItem = new JMenuItem();
	private final JMenuItem disconnectItem = new JMenuItem();
	private final JMenuItem englishItem = new JMenuItem();
	private final JMenuItem bulgarianItem = new JMenuItem();
	private final JButton sendButton = new JButton();
	private final JFrame mainFrame = new JFrame();
	private final MessageFormat messageFormatter = new MessageFormat("");
	private static final Logger LOGGER = Logger.getLogger(SwingClient.class);

	private ResourceBundle buttonsBundle;
	private ResourceBundle hoursBundle;
	private ResourceBundle messageBundle;
	private ResourceBundle labelsBundle;
	private DateFormat formatter;
	private int index;
	/**
	 * Comment for serialVersionUID.
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -7758850056548062247L;

	/**
	 * Init the UI. The UI is initiated in the EDT.
	 */
	private void initUI() {
		updateUI();
		mainFrame.setPreferredSize(new Dimension(700, 600));

		JPanel messagePane = new JPanel(new BorderLayout(15, 15));
		userList.setBackground(Color.gray);
		userList.setForeground(Color.white);
		userList.setPrototypeCellValue("jjjggfgddfg");
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
		console.setFixedCellHeight(100);
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
	private void updateUI() {
		labelsBundle = ResourceBundle.getBundle("ClientLabelsBundle", getCurrentLocale());
		buttonsBundle = ResourceBundle.getBundle("ClientButtonsBundle", getCurrentLocale());
		hoursBundle = ResourceBundle.getBundle("HoursBundle", getCurrentLocale());
		messageBundle = ResourceBundle.getBundle("ClientMessagesBundle", getCurrentLocale());
		formatter = new SimpleDateFormat(hoursBundle.getString("hours"));
		mainFrame.setTitle(labelsBundle.getString("main"));
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
			try {
				closeConnection();
			} catch (NullPointerException e1) {
			}
		else {
			if ("eng".equals(command))
				setCurrentLocale(getLocaleFromIndex(0));
			else if ("bg".equals(command))
				setCurrentLocale(getLocaleFromIndex(1));

			updateUI();
		}
	}

	@Override
	public void onUserAdded(final String user) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				userListModel.addElement(user);

			}
		});
		messageFormatter.applyPattern(messageBundle.getString("connectMessage"));
		String localizedMessage = messageFormatter.format(new String[] { user });
		addMessage(new Message(localizedMessage, formatter.format(new Date()), "System", new Color(
				34, 139, 34)));
		LOGGER.info(localizedMessage);

	}

	@Override
	public void onUserRemoved(final String user) {
		messageFormatter.applyPattern(messageBundle.getString("disconnectMessage"));
		String localizedMessage = messageFormatter.format(new String[] { user });

		addMessage(new Message(localizedMessage, formatter.format(new Date()), "System", new Color(
				34, 139, 34)));
		userListModel.removeElement(user);
		LOGGER.info(localizedMessage);

	}

	@Override
	public void onMessageAdded(final String user, final String message) {
		LOGGER.info(user + ":" + message);
		addMessage(new Message(message, formatter.format(new Date()), user));

	}

	/**
	 * Called when a message/connection message/error is received. Checks if there are already 20
	 * messages in the list, if there are remove 1 and add the new message.
	 * 
	 * @param message
	 *            the received message.
	 */
	private void addMessage(final Message message) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				if (messageModel.size() == 20) {
					messageModel.remove(0);
				}
				messageModel.addElement(message);
				console.ensureIndexIsVisible(messageModel.indexOf(messageModel.lastElement()));
			}
		});
	}

	/**
	 * Send the message from the messageField to the server and clear it.
	 */
	private void send() {
		try {
			sendMessage(messageField.getText());
		} catch (NullPointerException e) {
		}
		states.add(originator.saveMemento(messageField.getText()));
		index = states.size();
		messageField.setText("");
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

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
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				initUI();

			}
		});

	}

	@Override
	public void onConnectionClosed() {
		userListModel.removeAllElements();
		addMessage(new Message(messageBundle.getString("connectionTerminated"),
				formatter.format(new Date()), "System", new Color(34, 139, 34)));
	}

	@Override
	public void onError(final String arg0) {
		addMessage(new Message(messageBundle.getString(arg0), formatter.format(new Date()),
				"Error", Color.red));
		LOGGER.error(messageBundle.getString(arg0));

	}

	@Override
	public void onUserList(String userList) {
		for (final String user : userList.split(","))
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					userListModel.addElement(user);

				}
			});

	}
}
