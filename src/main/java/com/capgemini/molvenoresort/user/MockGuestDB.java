package com.capgemini.molvenoresort.user;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class MockGuestDB {
	private static MockGuestDB guestDB = null;
	private static List<Guest> guests = new ArrayList<>();
	private static int counter = 4;

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
		guests.add(new Guest(1, "pw2"));
		guests.add(new Guest(2, "aser12"));
		guests.add(new Guest(3, "qwerty"));
		guests.add(new Guest(4, "12345678"));
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public ResponseEntity<Guest> getGuestById(long id) {
		for (Guest guest:guests) {
			if (guest.getGuestId() == id) {
				return ResponseEntity.ok(guest);
			}
		}

		return ResponseEntity.notFound().build();
	}

	public void addGuest(Guest guest) {
		guest.setGuestId(++counter);
		guests.add(guest);
	}
}
