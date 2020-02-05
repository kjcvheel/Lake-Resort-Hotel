package com.capgemini.molvenoresort.user;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class MockGuestDB {
	private static MockGuestDB guestDB = null;
	private static List<Guest> guests = new ArrayList<>();
	private static int counter = 0;

/*	private MockGuestDB() {
		fillRoomTable();
	}*/

	public static MockGuestDB getInstance() {
		if (guestDB == null) {
			guestDB = new MockGuestDB();
		}

		return guestDB;
	}

/*	private void fillRoomTable() {
		addGuest(new Guest("pw2"));
		addGuest(new Guest("aser12"));
		addGuest(new Guest( "qwerty"));
		addGuest(new Guest("12345678"));
	}*/

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

/*	public void addGuest(Guest guest) {
		guest.setGuestId(++counter);
		guests.add(guest);
	}*/
}
