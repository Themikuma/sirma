package com.sirma.itt.javacourse.gui.task1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Calculator extends JFrame {
	private JTextField screen = new JTextField();

	public Calculator(int width, int height) {
		setSize(width, height);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		screen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		screen.setEditable(false);
		screen.setText("0");
		screen.setBackground(Color.white);
		contentPane.add(screen, BorderLayout.NORTH);
		contentPane.add(new ButtonPane(new CommandListener(this)), BorderLayout.CENTER);
		setContentPane(contentPane);
		setVisible(true);
	}

	public void setScreenText(String text) {
		screen.setText(text);
	}

	public String getScreenText() {
		return screen.getText();
	}

	/**
	 * Getter method for screen.
	 * 
	 * @return the screen
	 */
	public JTextField getScreen() {
		return screen;
	}

	/**
	 * Setter method for screen.
	 * 
	 * @param screen
	 *            the screen to set
	 */
	public void setScreen(JTextField screen) {
		this.screen = screen;
	}

	/**
	 * Getter method for firstNumber.
	 * 
	 * @return the firstNumber
	 */

}
