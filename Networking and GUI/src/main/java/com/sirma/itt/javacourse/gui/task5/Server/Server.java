package com.sirma.itt.javacourse.gui.task5.Server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame implements ActionListener {
	private JTextArea console = new JTextArea();

	public Server() {

	}

	public void initUI() {
		setSize(300, 200);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		// TODO rename downloadBTN
		JButton downloadBtn = new JButton("Stop");
		downloadBtn.addActionListener(this);
		contentPane.add(console, BorderLayout.CENTER);
		contentPane.add(downloadBtn, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void startListening() {
		Thread thread = new Thread(new ServerListener(JOptionPane.showInputDialog("Enter host"),
				console));
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
