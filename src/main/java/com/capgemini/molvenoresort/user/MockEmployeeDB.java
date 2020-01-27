package com.capgemini.molvenoresort.user;

import java.util.ArrayList;
import java.util.List;

public class MockEmployeeDB {
	private static MockEmployeeDB employeeDB = null;
	private static List<Employee> employees = new ArrayList<>();

	private MockEmployeeDB() {
		fillRoomTable();
	}

	public static MockEmployeeDB getInstance() {
		if (employeeDB == null) {
			employeeDB = new MockEmployeeDB();
		}

		return employeeDB;
	}

	private void fillRoomTable() {
		employees.add(new Employee("E001", "pw2", EmployeeRole.RECEPTIONIST));
		employees.add(new Employee("E002", "aser12", EmployeeRole.RECEPTIONIST));
		employees.add(new Employee("E003", "qwerty", EmployeeRole.CHEF));
		employees.add(new Employee("E004", "12345678", EmployeeRole.GENERAL_MANAGER));
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public Employee getEmployeeById(String id) {
		for (Employee e:employees) {
			if (e.getEmployeeId().equals(id)){
				return e;
			}
		}
		return null;
	}

	public void addEmployee(String id, String password) {
		employees.add(new Employee(id, password, EmployeeRole.RECEPTIONIST));
	}
}
