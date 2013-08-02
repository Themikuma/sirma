package com.sirma.itt.javacourse.chat.server.maincomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class SwingServer extends ServerMainUnit implements ActionListener {

	private JTextArea console = new JTextArea();
	private JFrame frame = new JFrame();
	private Logger logger = Logger.getLogger(this.getClass());
	private JMenu serverMenu = new JMenu();
	private JMenu languageMenu = new JMenu();
	private JMenuItem startServer = new JMenuItem();
	private JMenuItem stopServer = new JMenuItem();
	private JMenuItem englishMenu = new JMenuItem();
	private JMenuItem bulgarianMenu = new JMenuItem();
	private ResourceBundle buttonsBundle;
	/**
	 * Comment for serialVersionUID.
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -4342026673924478849L;

	private void updateUI() {
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
		buttonsBundle = ResourceBundle.getBundle("ButtonsBundle", getCurrentLocale());
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
			stopServer();
		else {
			if ("eng".equals(command))
				setCurrentLocale(getLocaleFromIndex(0));
			else
				setCurrentLocale(getLocaleFromIndex(1));
			buttonsBundle = ResourceBundle.getBundle("ButtonsBundle", getCurrentLocale());
			updateUI();

		}

	}

	@Override
	public void addMessage(String arg0, String arg1) {
		console.append(arg0 + ":" + arg1 + System.lineSeparator());
		logger.info(arg0 + ":" + arg1);

	}

	@Override
	public void disconnect() {
		console.append("Server has stopped");
		logger.info("Server has stopped");

	}

	@Override
	public void onServerStopped() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUserAdded(String arg0) {
		console.append("arg0" + "has connected");
		logger.info("arg0" + "has connected");

	}

	@Override
	public void onUserRemoved(String arg0) {
		console.append("arg0" + "has disconnected");
		logger.info("arg0" + "has disconnected");

	}
}
