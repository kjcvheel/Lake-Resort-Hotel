package com.capgemini.user;

import java.util.ArrayList;
import java.util.List;

public class MockGuestDB {
	private static MockGuestDB guestDB = null;
	private static List<Guest> guests = new ArrayList<>();

	private MockGuestDB() {
		fillRoomTable();
	}

	public static MockGuestDB getInstance() {
		if (guestDB == null) {
			guestDB = new MockGuestDB();
		}

		return guestDB;
	}

	private void fillRoomTable() {
		guests.add(new Guest("G001", "pw2"));
		guests.add(new Guest("G002", "aser12"));
		guests.add(new Guest("G003", "qwerty"));
		guests.add(new Guest("G004", "12345678"));
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public void addGuest(String id, String password) {
		guests.add(new Guest(id, password));
	}
}
