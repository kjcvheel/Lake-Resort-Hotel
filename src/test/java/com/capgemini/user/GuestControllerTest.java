package com.capgemini.user;

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
		Guest guest = guestController.getGuestById("G001");
		assertEquals("G001", guest.getGuestId());

		guest = guestController.getGuestById("fsdgs");
		assertNull(guest);
	}

	@Test
	public void addEmployeeTest() {
		int beforeSize = guestController.getGuests().size();
		guestController.addGuest("G071");
		List<Guest> guests = guestController.getGuests();
		assertEquals(beforeSize+1, guests.size());
		assertEquals("G071", guests.get(beforeSize).getGuestId());
	}
}
