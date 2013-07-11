package com.sirma.itt.javacourse.gui.task6.Server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.SocketFinder;
import com.sirma.itt.javacourse.gui.task6.ChannelManager;

/**
 * The main window of the server.
 * 
 * @author user
 */
public class Server extends JFrame implements ActionListener {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1761970612281989558L;
	private ChannelManager mediator = new ChannelManager();
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> channels = new JList<>(model);
	private boolean continueExecution;
	private Locale[] supported = { Locale.ENGLISH, Locale.GERMAN, new Locale("bg") };
	private ResourceBundle stringBundle = ResourceBundle.getBundle("StringsBundle", supported[2]);

	/**
	 * Set the size and components of the window.
	 */
	public void initUI() {
		setPreferredSize(new Dimension(400, 600));
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		JPanel controlPane = new JPanel(new GridLayout(0, 3, 15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		ResourceBundle bundle = ResourceBundle.getBundle("ButtonsBundle", supported[2]);

		JButton addChannel = new JButton(bundle.getString("addChannel"));
		JButton removeChannel = new JButton(bundle.getString("removeChannel"));
		JButton sendSignal = new JButton(bundle.getString("sendSignal"));

		addChannel.setActionCommand("+");
		removeChannel.setActionCommand("-");
		sendSignal.setActionCommand("Send");

		addChannel.addActionListener(this);
		removeChannel.addActionListener(this);
		sendSignal.addActionListener(this);
		controlPane.add(addChannel);
		controlPane.add(removeChannel);
		controlPane.add(sendSignal);
		contentPane.add(channels, BorderLayout.CENTER);
		contentPane.add(controlPane, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		pack();
		setLocation(screenCentre.x - getHeight() / 2, screenCentre.y - getWidth() / 2);
		setVisible(true);
	}

	/**
	 * Start the thread that is going to listen for clients connection.
	 */
	public void startListening() {
		setEnabled(false);
		String host;

		while ((host = JOptionPane.showInputDialog(stringBundle.getString("host"))) != null) {
			ServerSocket socket = SocketFinder.getAvailableServerSocket(host, 7000, 7020);
			if (socket != null) {
				setEnabled(true);
				Thread thread = new Thread(new CustomServerListener(socket, mediator));
				thread.setDaemon(true);
				thread.start();
				continueExecution = true;
				break;
			}
		}
		if (!continueExecution)
			dispose();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("+".equals(command)) {
			String channelName = JOptionPane.showInputDialog(null,
					stringBundle.getObject("enterName"));
			model.addElement(channelName);
			mediator.addChannel(channelName);

		} else if ("-".equals(command)) {
			model.remove(channels.getSelectedIndex());
		} else {
			mediator.sendMessage(channels.getSelectedValue(), stringBundle.getString("message"));
		}

	}

}
