/*
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
		Employee employee = employeeController.getEmployeeById(1L).getBody();
		assertEquals(1, employee.getEmployeeId());

		employee = employeeController.getEmployeeById(99999999L).getBody();
		assertNull(employee);
	}

	@Test
	public void addEmployeeTest() {
		int beforeSize = employeeController.getEmployees().size();
		Employee employee = new Employee(5, "hijo", EmployeeRole.GENERAL_MANAGER);
		employeeController.addEmployee(employee);
		List<Employee> employees = employeeController.getEmployees();
		assertEquals((beforeSize+1), employees.size());
		assertEquals(5, employees.get(beforeSize).getEmployeeId());
	}
}
*/
