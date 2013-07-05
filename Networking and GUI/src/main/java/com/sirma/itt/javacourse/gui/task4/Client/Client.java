package com.sirma.itt.javacourse.gui.task4.Client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

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
	private static final long serialVersionUID = -761330359858286865L;
	private JTextArea console = new JTextArea();

	/**
	 * Setting up the size and components of the window.
	 */
	public void initUI() {
		setPreferredSize(new Dimension(300, 200));
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		JButton connectBtn = new JButton("Connect");
		connectBtn.addActionListener(this);
		connectBtn.setActionCommand("Connect");
		contentPane.add(console, BorderLayout.CENTER);
		contentPane.add(connectBtn, BorderLayout.SOUTH);
		setContentPane(contentPane);
		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		pack();
		setLocation(screenCentre.x - getHeight() / 2, screenCentre.y - getWidth() / 2);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		connect();

	}

	/**
	 * Start the thread that is going to connect to the server at the given host.
	 */
	public void connect() {
		Socket socket;
		setEnabled(false);
		while ((socket = SocketFinder.getAvailableSocket(JOptionPane.showInputDialog("host"), 7000,
				7020)) == null) {
		}
		setEnabled(true);
		Thread thread = new Thread(new CustomClientListener(socket, console));
		thread.setDaemon(true);
		thread.start();
	}

}
