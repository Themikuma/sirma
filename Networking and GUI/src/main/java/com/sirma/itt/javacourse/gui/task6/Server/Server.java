package com.sirma.itt.javacourse.gui.task6.Server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;

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

	/**
	 * Set the size and components of the window.
	 */
	public void initUI() {
		setPreferredSize(new Dimension(400, 600));
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		JPanel controlPane = new JPanel(new GridLayout(0, 3, 15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		JButton addChannel = new JButton("+");
		JButton removeChannel = new JButton("-");
		JButton sendSignal = new JButton("Send");
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
		ServerSocket socket;
		setEnabled(false);
		while ((socket = SocketFinder.getAvailableServerSocket(JOptionPane.showInputDialog("host"),
				7000, 7020)) == null) {

		}
		setEnabled(true);
		Thread thread = new Thread(new CustomServerListener(socket, mediator, model));
		thread.setDaemon(true);
		thread.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("+".equals(command)) {
			String channelName = JOptionPane.showInputDialog(null, "Enter the channel's ip: ");
			model.addElement(channelName);
			mediator.addChannel(channelName);

		} else if ("-".equals(command)) {
			model.remove(channels.getSelectedIndex());
		} else {
			mediator.sendMessage(channels.getSelectedValue(), "You have been selected");
		}

	}

}
