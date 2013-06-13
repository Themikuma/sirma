package com.sirma.itt.javacourse.gui.task2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DownloadAgent extends JFrame implements ActionListener {
	private JTextField url = new JTextField();
	private JProgressBar progressBar = new JProgressBar();

	public DownloadAgent() {
		setSize(300, 200);
		JPanel contentPane = new JPanel(new BorderLayout(15, 15));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		JButton downloadBtn = new JButton("Download");
		downloadBtn.addActionListener(this);
		contentPane.add(url, BorderLayout.NORTH);
		contentPane.add(downloadBtn, BorderLayout.CENTER);
		contentPane.add(progressBar, BorderLayout.SOUTH);
		setContentPane(contentPane);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		URLConnection connection = null;
		try {
			URL address = new URL(url.getText());
			connection = address.openConnection();

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (BufferedInputStream reader = new BufferedInputStream(connection.getInputStream());
				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(
						"asd.png"))) {
			int line;
			int i = 0;
			while ((line = reader.read()) != -1) {
				// System.out.println(line);
				output.write(line);
				progressBar.setValue(i++);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
