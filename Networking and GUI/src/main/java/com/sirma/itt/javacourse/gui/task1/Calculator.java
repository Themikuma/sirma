package com.sirma.itt.javacourse.gui.task1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * The main window of the calculator.
 * 
 * @author user
 */
public class Calculator extends JFrame {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -6687411057486141891L;
	private JTextField screen = new JTextField();

	/**
	 * Init the ui with the given width and height and set up the components.
	 * 
	 * @param width
	 *            the width of the window
	 * @param height
	 *            the height of the window
	 */
	public void initUI(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		screen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		screen.setEditable(false);
		screen.setText("0");
		screen.setBackground(Color.white);
		contentPane.add(screen, BorderLayout.NORTH);
		contentPane.add(new ButtonPane(new CommandListener(this)), BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(contentPane);
		Point screenCentre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		pack();
		setLocation(screenCentre.x - getHeight() / 2, screenCentre.y - getWidth() / 2);
		setVisible(true);
	}

	/**
	 * Set the screen text directly instead of getting its instance first.
	 * 
	 * @param text
	 *            the text to be set
	 */
	public void setScreenText(String text) {
		screen.setText(text);
	}

	/**
	 * Get the screen text directly instead of setting its instance first.
	 * 
	 * @return the text from the screen
	 */
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
