package com.capgemini.molvenoresort.user;

import com.capgemini.molvenoresort.user.Guest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class GuestTest {
	Guest guest;
	String testPW = "hashcode";

	@Rule
	public final ExpectedException exception = 	ExpectedException.none();

	@Before
	public void createGuest() {
		guest = new Guest(4, testPW, "Jeff", "Bouwmeester",  new GregorianCalendar(1980, Calendar.JULY, 12).getTime(), "Netherlands", "Zeewolde", "Villawal 1", "1234 ab", "030-123-5498", "+316-14325768", 12093487, "");
	}

	@Test
	public void guestIdTest() {
		assertEquals(4, guest.getGuestId());

		guest.setGuestId(71);
		assertEquals(71, guest.getGuestId());

		guest.setGuestId(-100);
		assertEquals(-100, guest.getGuestId());
	}

	@Test
	public void creditcardTest() {
		assertEquals(12093487, guest.getCreditcard());

		guest.setCreditcard(12345678);
		assertEquals(12345678, guest.getCreditcard());

		guest.setCreditcard(1234);
		assertEquals(1234, guest.getCreditcard());
	}

	@Test
	public void smallConstructorTest() {
		Guest guest2 = new Guest( testPW);
		assertEquals(testPW, guest2.getPassword());
	}
}
