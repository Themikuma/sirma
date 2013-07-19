package com.cit.chat.client;

import com.cit.chat.server.ServerMainThread;
import com.sirma.itt.javacourse.chat.client.maincomponents.GraphicalClient;
import com.sirma.itt.javacourse.chat.server.maincomponents.GraphicalServer;
import com.sirma.itt.javacourse.chat.structures.IClientMessages;

public class Test {

	@org.junit.Test
	public void test() throws InterruptedException {
		int i = 0;
		GraphicalServer main = new GraphicalServer();
		main.initUI();
		Thread thread = new Thread(new ServerMainThread("localhost", main.getConsole()));
		thread.start();
		GraphicalClient original = new GraphicalClient();
		original.initUI();
		ServerMessagesReadThread originalListener = new ServerMessagesReadThread("", new LoginForm(
				original), original);
		Thread originalThread = new Thread(originalListener);
		originalThread.start();
		Thread.sleep(1000);
		originalListener.sendMessage(IClientMessages.CONNECTION_ATTEMPT + "|" + i);
		i++;

		for (int j = 0; j < 50; j++) {
			GraphicalClient frame = new GraphicalClient();
			frame.initUI();
			ServerMessagesReadThread listener = new ServerMessagesReadThread("", new LoginForm(
					frame), frame);
			Thread threada = new Thread(listener);
			threada.start();
			Thread.sleep(100);
			listener.sendMessage(IClientMessages.CONNECTION_ATTEMPT + "|" + i);
			i++;

		}
		Thread.sleep(1000000);
	}
}
