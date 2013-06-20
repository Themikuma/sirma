package com.sirma.itt.javacourse.gui.task2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DownloadAgent extends JFrame implements ActionListener {
	private JTextField urlTxtField = new JTextField();
	private JProgressBar progressBar = new JProgressBar();

	public DownloadAgent() {
		setSize(300, 200);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		JButton downloadBtn = new JButton("Download");
		downloadBtn.addActionListener(this);
		contentPane.add(urlTxtField, BorderLayout.NORTH);
		contentPane.add(downloadBtn, BorderLayout.CENTER);
		contentPane.add(progressBar, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread downloadThread = new Thread(new Downloader(this));
		downloadThread.start();
	}

	public String getUrl() {
		return urlTxtField.getText();

	}

	public void updateProgressBar(int value) {
		progressBar.setValue(value);
	}

	/**
	 * Getter method for url.
	 * 
	 * @return the url
	 */
	public JTextField getUrlTextField() {
		return urlTxtField;
	}

	/**
	 * Setter method for url.
	 * 
	 * @param url
	 *            the url to set
	 */
	public void setUrlTextField(JTextField url) {
		this.urlTxtField = url;
	}

	/**
	 * Getter method for progressBar.
	 * 
	 * @return the progressBar
	 */
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	/**
	 * Setter method for progressBar.
	 * 
	 * @param progressBar
	 *            the progressBar to set
	 */
	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}
}
