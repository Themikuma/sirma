package com.sirma.itt.javacourse.gui.task3.Server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.sockets.Console;
import com.sirma.itt.javacourse.gui.sockets.SocketFinder;

/**
 * The main window of the server.
 * 
 * @author user
 */
public class Server extends JFrame implements ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 4573188303321380533L;
	private Console console = new Console();
	private boolean continueExecution = false;

	/**
	 * Setting up the size and components of the window.
	 */
	public void initUI() {
		setPreferredSize(new Dimension(300, 200));
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		JButton stopBtn = new JButton("Stop");
		stopBtn.addActionListener(this);
		stopBtn.setActionCommand("Stop");
		contentPane.add(console, BorderLayout.CENTER);
		contentPane.add(stopBtn, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		pack();
		setLocation(screenCentre.x - getHeight() / 2, screenCentre.y - getWidth() / 2);
		setVisible(true);
	}

	/**
	 * Start the server on an available port.
	 */
	public void startListening() {

		setEnabled(false);
		String host;

		while ((host = JOptionPane.showInputDialog("host")) != null) {
			ServerSocket socket = SocketFinder.getAvailableServerSocket(host, 7000, 7020);
			if (socket != null) {
				setEnabled(true);
				Thread thread = new Thread(new CustomServerListener(socket, console));
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

		dispose();

	}

}
