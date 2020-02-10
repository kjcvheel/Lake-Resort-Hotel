package com.capgemini.molvenoresort.user;

import com.capgemini.molvenoresort.enums.EmployeeRole;
import com.capgemini.molvenoresort.models.Employee;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
	Employee employee;
	String testPW = "hashcode";

	@Rule
	public final ExpectedException exception = 	ExpectedException.none();

	@Before
	public void createEmployee() {
		employee = new Employee(4, testPW, EmployeeRole.RECEPTIONIST, "Jeff", "Bouwmeester",  new GregorianCalendar(1980, Calendar.JULY, 12).getTime(), "Netherlands", "Zeewolde", "Villawal 1", "1234 ab", "030-123-5498", "+316-14325768", "", "");
	}

//	@Test
//	public void photoTest() {
//		assertEquals("", employee.getPhoto());
//
//		employee.setPhoto("test");
//		assertEquals("test", employee.getPhoto());
//
//		employee.setPhoto("231m1lnn");
//		assertEquals("231m1lnn", employee.getPhoto());
//	}

	@Test
	public void employeeIdTest() {
		assertEquals(4, employee.getEmployeeId());

		employee.setEmployeeId(8);
		assertEquals(8, employee.getEmployeeId());

		employee.setEmployeeId(-9999);
		assertEquals(-9999, employee.getEmployeeId());
	}

	@Test
	public void employeeRoleTest() {
		assertEquals(EmployeeRole.RECEPTIONIST, employee.getRole());

		employee.setRole(EmployeeRole.CHEF);
		assertEquals(EmployeeRole.CHEF, employee.getRole());

		employee.setRole(EmployeeRole.GENERAL_MANAGER);
		assertEquals(EmployeeRole.GENERAL_MANAGER, employee.getRole());

		assertEquals(3, EmployeeRole.values().length);
	}

//	@Test
//	public void smallConstructorTest() {
//		Employee employee2 = new Employee(5, testPW, EmployeeRole.GENERAL_MANAGER);
//
//		assertEquals(5, employee2.getEmployeeId());
//		assertEquals(testPW, employee2.getPassword());
//		assertEquals(EmployeeRole.GENERAL_MANAGER, employee2.getRole());
//	}
}
