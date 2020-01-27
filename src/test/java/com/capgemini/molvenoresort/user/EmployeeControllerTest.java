package com.capgemini.molvenoresort.user;

import com.capgemini.molvenoresort.user.Employee;
import com.capgemini.molvenoresort.user.EmployeeController;
import com.capgemini.molvenoresort.user.MockEmployeeDB;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EmployeeControllerTest {
	EmployeeController employeeController;
	int employeeDBRows = 0;

	@Before
	public void before() {
		employeeController = new EmployeeController();
		employeeDBRows = MockEmployeeDB.getInstance().getEmployees().size();
	}

	@Test
	public void getEmployeesTest() {
		List<Employee> employees = employeeController.getEmployees();
		assertEquals(employeeDBRows, employees.size());
	}

	@Test
	public void getEmployeeByIdTest() {
		Employee employee = employeeController.getEmployeeById("E001");
		assertEquals("E001", employee.getEmployeeId());

		employee = employeeController.getEmployeeById("dfas");
		assertNull(employee);
	}

	@Test
	public void addEmployeeTest() {
		int beforeSize = employeeController.getEmployees().size();
		employeeController.addEmployee("E005", "hijo");
		List<Employee> employees = employeeController.getEmployees();
		assertEquals((int)(beforeSize+1), employees.size());
		assertEquals("E005", employees.get(beforeSize).getEmployeeId());
	}
}
