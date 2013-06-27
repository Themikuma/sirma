package com.sirma.itt.javacourse.gui.task4.Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

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
	private Socket socket;

	/**
	 * Setting up the size and components of the window.
	 */
	public Client() {

	}

	public void initUI() {
		setSize(300, 200);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		JButton downloadBtn = new JButton("Connect");
		downloadBtn.addActionListener(this);
		contentPane.add(console, BorderLayout.CENTER);
		contentPane.add(downloadBtn, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		connect(JOptionPane.showInputDialog("Enter host"));

	}

	/**
	 * Find an available server and connect to it.
	 */
	public void connect(String host) {
		Thread thread = new Thread(new ClientListener(host, console));
		thread.start();
	}

}
