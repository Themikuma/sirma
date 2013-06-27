package com.sirma.itt.javacourse.gui.task3.Client;

import java.awt.BorderLayout;

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
public class Client extends JFrame {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 4812376091391793740L;
	private JTextArea console = new JTextArea();

	/**
	 * Setting up the size and components of the client window.
	 */
	public Client() {
	}

	public void initUI() {
		setSize(300, 200);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		contentPane.add(console, BorderLayout.CENTER);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void startListening() {
		Thread thread = new Thread(new ClientListener(JOptionPane.showInputDialog("Enter host"),
				console));
		thread.start();
	}

}
