package com.sirma.itt.javacourse.gui.task6;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.sirma.itt.javacourse.gui.sockets.ClientWrapper;

/**
 * The mediator that handles the sending of messages to different groups of people.
 * 
 * @author user
 */
public class ChannelManager {
	private Map<String, List<ClientWrapper>> channelList = new HashMap<>();
	private Locale[] supported = { Locale.ENGLISH, new Locale("bg") };

	/**
	 * Add a user to the specified channel in the map.
	 * 
	 * @param channelName
	 *            the channel to add the user to
	 * @param user
	 *            the user
	 */
	public void addUser(String channelName, ClientWrapper user) {
		if (channelList.containsKey(channelName)) {
			user.sendMessage("Succesfully joined channel");
			List<ClientWrapper> users = channelList.get(channelName);
			users.add(user);

		} else {
			user.sendMessage("Channel does not exist");
		}

	}

	/**
	 * Add a channel to the map.
	 * 
	 * @param channelName
	 *            the name of the channel
	 */
	public void addChannel(String channelName) {
		channelList.put(channelName, new ArrayList<ClientWrapper>());
	}

	/**
	 * Remove a user from the map from all channels.
	 * 
	 * @param user
	 *            the user to remove
	 */
	public void removeUser(ClientWrapper user) {
		Collection<List<ClientWrapper>> userLists = channelList.values();
		for (List<ClientWrapper> list : userLists) {
			user.closeConnection();
			list.remove(user);
		}
	}

	/**
	 * Send the specified message to all the users from the specified channel.
	 * 
	 * @param channelName
	 *            the channel to be sent to
	 * @param message
	 *            the message to be sent
	 */
	public void sendMessage(String channelName, String message) {
		List<ClientWrapper> users = channelList.get(channelName);

		ResourceBundle daysBundle = ResourceBundle.getBundle("DaysBundle", supported[1]);
		SimpleDateFormat formatter;
		DateFormatSymbols symbols = new DateFormatSymbols(supported[1]);
		symbols.setShortWeekdays(daysBundle.getString("days").split(","));
		formatter = new SimpleDateFormat("E H:mm", symbols);
		for (ClientWrapper user : users) {
			user.sendMessage(formatter.format(new Date()) + ":" + message);
		}
	}
}
