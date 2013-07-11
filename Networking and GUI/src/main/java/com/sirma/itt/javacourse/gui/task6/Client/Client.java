package com.sirma.itt.javacourse.gui.task6.Client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.Console;
import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

/**
 * The main window of the client.
 * 
 * @author user
 */
public class Client extends JFrame implements ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -5253366624548030477L;
	private Console console = new Console();
	private CustomClientListener listener;
	private boolean continueExecution;

	/**
	 * Setting up the size and components of the window.
	 */
	public void initUI() {
		setPreferredSize(new Dimension(300, 400));
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		JButton connectBtn = new JButton("Connect");
		JButton closeBtn = new JButton("Disconnect");
		connectBtn.setActionCommand("Connect");
		closeBtn.setActionCommand("Disconnect");
		connectBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		contentPane.add(console, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel(new GridLayout(0, 1));
		buttonPane.add(connectBtn);
		buttonPane.add(closeBtn);
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		pack();
		setLocation(screenCentre.x - getHeight() / 2, screenCentre.y - getWidth() / 2);
		setVisible(true);
	}

	/**
	 * Start the thread that is going to connect to the server at the given host. the host of the
	 * server to connect to
	 */
	public void connect() {
		setEnabled(false);
		String host;

		while ((host = JOptionPane.showInputDialog("host")) != null) {
			Socket socket = SocketFinder.getAvailableSocket(host, 7000, 7020);
			if (socket != null) {
				setEnabled(true);
				listener = new CustomClientListener(socket, console);
				Thread thread = new Thread(listener);
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
		if ("Connect".equals(command))
			listener.sendMessage("connect:"
					+ JOptionPane.showInputDialog(null, "Enter the channel's ip: "));
		else {
			listener.sendMessage("disconnect");
		}

	}
}
