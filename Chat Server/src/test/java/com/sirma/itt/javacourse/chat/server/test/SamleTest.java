package com.sirma.itt.javacourse.chat.server.test;
import static org.junit.Assert.assertTrue;

import java.net.Socket;

import org.junit.Test;

import com.sirma.itt.javacourse.chat.server.UsersManager;
import com.sirma.itt.javacourse.chat.server.main.Server;
import com.sirma.itt.javacourse.chat.server.structures.Client;

/**
 * Unit tests for the server.
 * 
 * @author user
 */
public class SamleTest {

	/**
	 * Test the builder of the {@link Server}.
	 */
	@Test
	public void testServerBuilder() {
		Server server;
		server = new Server.ServerBuilder().build();
		assertTrue(server != null);
	}

	/**
	 * Test the addition of a new user in the list of users.
	 */
	@Test
	public void testUsersManagerAddUserSuccessful() {
		UsersManager manager = new UsersManager();

		boolean added = manager
				.addUser(new Client(new Socket(), new Server.ServerBuilder().build()));
		assertTrue(manager.getClientSet().size() == 1 && added);
	}

	/**
	 * Test the addition of a new user in the list of users with an incorrect or an already existing
	 * username.
	 */
	@Test
	public void testUsersManagerAddUserFail() {
		UsersManager manager = new UsersManager();
		manager.addUser(new Client(new Socket(), new Server.ServerBuilder().build()));
		boolean addedFirst = manager.addUser(new Client(new Socket(), new Server.ServerBuilder()
				.build()));
		boolean addedSecond = manager.addUser(new Client(new Socket(), new Server.ServerBuilder()
				.build()));
		assertTrue(manager.getClientSet().size() == 1 && !addedFirst && !addedSecond);
	}
}
