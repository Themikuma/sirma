package com.sirma.itt.javacourse.gui.task5.Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sirma.itt.javacourse.gui.task5.Memento;
import com.sirma.itt.javacourse.gui.task5.Originator;

/**
 * The main client window.
 * 
 * @author user
 */
public class Client extends JFrame implements ActionListener, KeyListener {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 9043239861663899088L;
	private JTextArea console = new JTextArea();
	private JTextField msgField = new JTextField();
	private List<Memento> states = new ArrayList<>();
	private Originator originator = new Originator();
	private int index;
	private ClientListener listener;

	/**
	 * Setting up the size and components of the window.
	 */
	public Client() {

	}

	public void initUI() {
		setSize(400, 600);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		JPanel messagePane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		JButton downloadBtn = new JButton("Send");
		downloadBtn.addActionListener(this);
		msgField.addKeyListener(this);
		messagePane.add(console, BorderLayout.CENTER);
		messagePane.add(msgField, BorderLayout.SOUTH);
		contentPane.add(messagePane, BorderLayout.CENTER);
		contentPane.add(downloadBtn, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Find an available server and connect to it.
	 */
	public void connect() {
		listener = new ClientListener(JOptionPane.showInputDialog("Enter host"), console);
		Thread thread = new Thread(listener);
		thread.setDaemon(true);
		thread.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		states.add(originator.saveMemento(msgField.getText()));
		index = states.size();
		listener.sendMessage(msgField.getText());
		msgField.setText("");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && index != 0) {
			index--;
			msgField.setText(originator.restoreMemento(states.get(index)));
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN && index != states.size() - 1) {
			index++;
			msgField.setText(originator.restoreMemento(states.get(index)));
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
