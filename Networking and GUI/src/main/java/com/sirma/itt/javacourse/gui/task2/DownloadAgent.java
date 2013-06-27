package com.sirma.itt.javacourse.gui.task2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * The view of the download agent.
 * 
 * @author user
 */
public class DownloadAgent extends JFrame implements ActionListener {
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField urlTxtField = new JTextField();
	private JProgressBar progressBar = new JProgressBar();
	private JButton downloadBtn = new JButton("Download");

	/**
	 * Setting up the size and the main components of the frame.
	 */
	public DownloadAgent() {
		start();
	}

	/**
	 * Starting the frame.
	 */
	public void start() {
		setSize(300, 200);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		downloadBtn.addActionListener(this);
		contentPane.add(urlTxtField, BorderLayout.NORTH);
		contentPane.add(downloadBtn, BorderLayout.CENTER);
		contentPane.add(progressBar, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	/**
	 * Starts a new thread that downloads the file from the path contained in the urlTextField.
	 */
	private void download() {
		Downloader downloader = new Downloader(urlTxtField.getText());
		downloader.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("progress".equals(evt.getPropertyName()))
					progressBar.setValue((int) evt.getNewValue());
				else if ("DONE".equals(evt.getNewValue().toString()))
					downloadBtn.setEnabled(true);
			}
		});
		downloadBtn.setEnabled(false);
		downloader.execute();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		download();
	}

}
