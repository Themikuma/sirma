package com.sirma.itt.javacourse.chat.server.maincomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

/**
 * A graphical implementation of the {@link ServerMainUnit}.
 * 
 * @author user
 */
public final class SwingServer extends ServerMainUnit implements ActionListener {

	private final JTextArea console = new JTextArea();
	private final JFrame frame = new JFrame();
	private static final Logger LOGGER = Logger.getLogger(SwingServer.class);
	private final JMenu serverMenu = new JMenu();
	private final JMenu languageMenu = new JMenu();
	private final JMenuItem startServer = new JMenuItem();
	private final JMenuItem stopServer = new JMenuItem();
	private final JMenuItem englishMenu = new JMenuItem();
	private final JMenuItem bulgarianMenu = new JMenuItem();

	private final MessageFormat messageFormatter = new MessageFormat("");
	private DateFormat formatter;

	private ResourceBundle buttonsBundle;
	private ResourceBundle hoursBundle;
	private ResourceBundle messagesBundle;
	private ResourceBundle labelsBundle;
	/**
	 * Comment for serialVersionUID.
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -4342026673924478849L;

	/**
	 * Updates the text of the ui elements according to the chosen language.
	 */
	private void updateUI() {
		buttonsBundle = ResourceBundle.getBundle("ButtonsBundle", getCurrentLocale());
		messagesBundle = ResourceBundle.getBundle("MessagesBundle", getCurrentLocale());
		labelsBundle = ResourceBundle.getBundle("LabelsBundle", getCurrentLocale());
		hoursBundle = ResourceBundle.getBundle("HoursBundle", getCurrentLocale());
		formatter = new SimpleDateFormat(hoursBundle.getString("hours"));

		frame.setTitle(labelsBundle.getString("server"));
		serverMenu.setText(buttonsBundle.getString("server"));
		languageMenu.setText(buttonsBundle.getString("language"));
		startServer.setText(buttonsBundle.getString("start"));
		stopServer.setText(buttonsBundle.getString("stop"));
		englishMenu.setText(buttonsBundle.getString("english"));
		bulgarianMenu.setText(buttonsBundle.getString("bulgarian"));
	}

	/**
	 * Init the UI. This is done on the EDT.
	 */
	private void initUI() {

		frame.setPreferredSize(new Dimension(300, 300));
		frame.setTitle("Swing Server");
		console.setEditable(false);
		JScrollPane scroll = new JScrollPane(console);
		JMenuBar mainMenu = new JMenuBar();

		startServer.setActionCommand("start");
		stopServer.setActionCommand("stop");
		englishMenu.setActionCommand("eng");
		bulgarianMenu.setActionCommand("bg");

		startServer.addActionListener(this);
		stopServer.addActionListener(this);
		englishMenu.addActionListener(this);
		bulgarianMenu.addActionListener(this);

		mainMenu.add(serverMenu);
		mainMenu.add(languageMenu);
		serverMenu.add(startServer);
		serverMenu.add(stopServer);
		languageMenu.add(englishMenu);
		languageMenu.add(bulgarianMenu);

		frame.add(mainMenu, BorderLayout.NORTH);
		frame.add(scroll, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		frame.pack();
		frame.setLocation(screenCentre.x - frame.getHeight() / 2, screenCentre.y - frame.getWidth()
				/ 2);
		updateUI();
		frame.setVisible(true);
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
		String command = e.getActionCommand();
		if ("start".equals(command))
			startConnectionUnit();
		else if ("stop".equals(command))
			try {
				closeConnection();
			} catch (IOException e1) {
				onError("closeServer");
			}
		else {
			if ("eng".equals(command))
				setCurrentLocale(getLocaleFromIndex(0));
			else
				setCurrentLocale(getLocaleFromIndex(1));

			updateUI();

		}

	}

	@Override
	public void onMessageAdded(String arg0, String arg1) {
		addMessage(arg0 + ":" + arg1);
	}

	/**
	 * Add a message to the console and log it as info.
	 * 
	 * @param message
	 *            the message to be added
	 */
	public void addMessage(final String message) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				console.append("[" + formatter.format(new Date()) + "]" + message
						+ System.lineSeparator());
			}
		});

		LOGGER.info(message);
	}

	@Override
	public void onUserAdded(String arg0) {
		messageFormatter.applyPattern(messagesBundle.getString("connect"));
		addMessage(messageFormatter.format(new String[] { arg0 }));
	}

	@Override
	public void onUserRemoved(String arg0) {
		messageFormatter.applyPattern(messagesBundle.getString("disconnect"));
		addMessage(messageFormatter.format(new String[] { arg0 }));
	}

	@Override
	public void onConnectionClosed() {
		addMessage(messagesBundle.getString("stop"));
	}

	@Override
	public void onConnectionEstablished(String port) {
		messageFormatter.applyPattern(messagesBundle.getString("started"));
		addMessage(messageFormatter.format(new String[] { port }));
	}

	@Override
	public void onError(String arg0) {
		console.append(messagesBundle.getString(arg0));
		LOGGER.error(messagesBundle.getString(arg0));

	}
}
