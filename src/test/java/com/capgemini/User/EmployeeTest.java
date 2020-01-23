package com.capgemini.User;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
	Employee employee;

	@Rule
	public final ExpectedException exception = 	ExpectedException.none();

	@Before
	public void CreateUser() {
		employee = new Employee("E004", "hashcode", EmployeeRole.Receptionist, "Jeff", "Bouwmeester",  new GregorianCalendar(1980, Calendar.JULY, 12).getTime(), "Netherlands", "Zeewolde", "Villawal 1", "1234 ab", "030-123-5498", "+316-14325768", "");
	}

	@Test
	public void PhotoTest() {

	}

	@Test
	public void EmployeeIdTest() {

	}

	@Test
	public void EmployeeRoleTest() {
		
	}
}
