package com.sirma.itt.javacourse.gui.task2;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

public class DownloadAgentTest {

	private static Downloader downloader;

	@BeforeClass
	public static void setUp() {
		downloader = new Downloader(
				"file:///C:/Users/user/Documents/GitHub/sirma/Networking%20and%20GUI/resources/eclipse-SDK-4.2.2-win32-x86_64.zip");
	}

	@Test
	public void testFileName() {
		assertEquals("Awesome.png", downloader.getFileName("resources/Awesome.png"));

	}

	@Test
	public void testDownloadFile() {
		BigInteger bytesRead = downloader
				.downloadFile(
						"file:///C:/Users/user/Documents/GitHub/sirma/Networking%20and%20GUI/resources/eclipse-SDK-4.2.2-win32-x86_64.zip",
						"eclipse_2.zip");
		assertEquals(192270521, bytesRead.intValue());
	}
}
