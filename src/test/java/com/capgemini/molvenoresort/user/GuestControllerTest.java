package com.capgemini.molvenoresort.user;

import com.capgemini.molvenoresort.user.Guest;
import com.capgemini.molvenoresort.user.GuestController;
import com.capgemini.molvenoresort.user.MockGuestDB;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GuestControllerTest {
	GuestController guestController;
	int guestDBRows = 0;

	@Before
	public void before() {
		guestController = new GuestController();
		guestDBRows = MockGuestDB.getInstance().getGuests().size();
	}

	@Test
	public void getGuestsTest() {
		List<Guest> guest = guestController.getGuests();
		assertEquals(guestDBRows, guest.size());
	}

	@Test
	public void getGuestsByIdTest() {
		Guest guest = guestController.getGuestById(1L).getBody();
		assertEquals(1, guest.getGuestId());

		guest = guestController.getGuestById(999999L).getBody();
		assertNull(guest);
	}

	@Test
	public void addGuestTest() {
		int beforeSize = guestController.getGuests().size();
		Guest guest = new Guest(71,"Test234");
		guestController.addGuest(guest);
		List<Guest> guests = guestController.getGuests();
		assertEquals(beforeSize+1, guests.size());
		assertEquals(71, guests.get(beforeSize).getGuestId());
	}
}
