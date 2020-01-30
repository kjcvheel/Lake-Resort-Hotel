package com.capgemini.molvenoresort.user;

import com.capgemini.molvenoresort.user.Employee;
import com.capgemini.molvenoresort.user.EmployeeRole;
import com.capgemini.molvenoresort.user.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class UserTest {
	User user;

	@Rule
	public final ExpectedException exception = 	ExpectedException.none();

	@Before
	public void createUser() {
		user = new Employee("E004", "hashcode", EmployeeRole.RECEPTIONIST, "Jeff", "Bouwmeester",  new GregorianCalendar(1980, Calendar.JULY, 12).getTime(), "Netherlands", "Zeewolde", "Villawal 1", "1234 ab", "030-123-5498", "+316-14325768", "", "");
	}

	@Test
	public void firstNameTest() {
		assertEquals("Jeff", user.getFirstName());

		user.setFirstName("Harry");
		assertEquals("Harry", user.getFirstName());

		exception.expect(IllegalArgumentException.class);
		user.setFirstName("23112");
	}

	@Test
	public void lastNameTest() {
		assertEquals("Bouwmeester", user.getLastName());

		user.setLastName("van Dam");
		assertEquals("van Dam", user.getLastName());

		exception.expect(IllegalArgumentException.class);
		user.setLastName("23112");
	}

	@Test
	public void birthdayTest() {
		Date date = new GregorianCalendar(1980, Calendar.JULY, 12).getTime();
		assertEquals(date, user.getBirthday());

		date = new GregorianCalendar(1982, Calendar.JULY, 15).getTime();
		user.setBirthday(date);
		assertEquals(date, user.getBirthday());
	}

	@Test
	public void countryTest() {
		assertEquals("Netherlands", user.getCountry());

		user.setCountry("Germany");
		assertEquals("Germany", user.getCountry());

		user.setCountry("@55433532");
		assertEquals("@55433532", user.getCountry());
	}

	@Test
	public void cityTest() {
		assertEquals("Zeewolde", user.getCity());

		user.setCity("Utrecht");
		assertEquals("Utrecht", user.getCity());

		user.setCity("@55433512");
		assertEquals("@55433512", user.getCity());
	}

	@Test
	public void addressTest() {
		assertEquals("Villawal 1", user.getAddress());

		user.setAddress("Mookpad 1");
		assertEquals("Mookpad 1", user.getAddress());

		user.setAddress("@55433533");
		assertEquals("@55433533", user.getAddress());
	}

	@Test
	public void zipcodeTest(){
		assertEquals("1234 ab", user.getZipcode());

		user.setZipcode("4567 bv");
		assertEquals("4567 bv", user.getZipcode());

		user.setZipcode("@55433542");
		assertEquals("@55433542", user.getZipcode());
	}

	@Test
	public void phoneNumberTest() {
		assertEquals("030-123-5498", user.getPhoneNumber());

		user.setPhoneNumber("020-456-0989");
		assertEquals("020-456-0989", user.getPhoneNumber());

		user.setPhoneNumber("fdfd");
		assertEquals("fdfd", user.getPhoneNumber());
	}

	@Test
	public void mobileNumberTest() {
		assertEquals("+316-14325768", user.getMobileNumber());

		user.setMobileNumber("+316-11223344");
		assertEquals("+316-11223344", user.getMobileNumber());

		user.setMobileNumber("hjkk");
		assertEquals("hjkk", user.getMobileNumber());
	}

	@Test
	public void passwordTest() {
		assertEquals("hashcode", user.getPassword());

		user.setPassword("klklkl");
		assertEquals("klklkl", user.getPassword());
	}
}
