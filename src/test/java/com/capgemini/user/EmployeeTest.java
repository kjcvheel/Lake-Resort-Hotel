package com.capgemini.user;

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
	public void CreateEmployee() {
		employee = new Employee("E004", "hashcode", EmployeeRole.RECEPTIONIST, "Jeff", "Bouwmeester",  new GregorianCalendar(1980, Calendar.JULY, 12).getTime(), "Netherlands", "Zeewolde", "Villawal 1", "1234 ab", "030-123-5498", "+316-14325768", "");
	}

	@Test
	public void PhotoTest() {
		assertEquals("", employee.getPhoto());

		employee.setPhoto("test");
		assertEquals("test", employee.getPhoto());

		employee.setPhoto("231m1lnn");
		assertEquals("231m1lnn", employee.getPhoto());
	}

	@Test
	public void EmployeeIdTest() {
		assertEquals("E004", employee.getEmployeeId());

		employee.setEmployeeId("E008");
		assertEquals("E008", employee.getEmployeeId());

		employee.setEmployeeId("jk23mnss");
		assertEquals("jk23mnss", employee.getEmployeeId());
	}

	@Test
	public void EmployeeRoleTest() {
		assertEquals(EmployeeRole.RECEPTIONIST, employee.getRole());

		employee.setRole(EmployeeRole.CHEF);
		assertEquals(EmployeeRole.CHEF, employee.getRole());

		employee.setRole(EmployeeRole.GENERAL_MANAGER);
		assertEquals(EmployeeRole.GENERAL_MANAGER, employee.getRole());

		assertEquals(3, EmployeeRole.values().length);
	}

	@Test
	public void smallConstructorTest() {
		Employee employee2 = new Employee("E005", "hashcode", EmployeeRole.GENERAL_MANAGER);

		assertEquals("E005", employee2.getEmployeeId());
		assertEquals("hashcode", employee2.getPassword());
		assertEquals(EmployeeRole.GENERAL_MANAGER, employee2.getRole());
	}
}
