package com.sirma.itt.javacourse.gui.task4.Server;

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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

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
	private static final long serialVersionUID = -1434592263904383102L;
	private JTextArea console = new JTextArea();

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
		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		pack();
		setLocation(screenCentre.x - getHeight() / 2, screenCentre.y - getWidth() / 2);
		setVisible(true);
	}

	/**
	 * Start a thread that is going to listen for clients connection.
	 */
	public void startListening() {
		ServerSocket socket;
		setEnabled(false);
		while ((socket = SocketFinder.getAvailableServerSocket(JOptionPane.showInputDialog("host"),
				7000, 7020)) == null) {

		}
		setEnabled(true);
		Thread thread = new Thread(new CustomServerListener(socket, console));
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		dispose();

	}
}
