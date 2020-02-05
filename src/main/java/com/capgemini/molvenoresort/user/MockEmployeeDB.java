package com.capgemini.molvenoresort.user;

import org.springframework.http.ResponseEntity;

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
		employees.add(new Employee(1, "pw2", EmployeeRole.RECEPTIONIST));
		employees.add(new Employee(2, "aser12", EmployeeRole.RECEPTIONIST));
		employees.add(new Employee(3, "qwerty", EmployeeRole.CHEF));
		employees.add(new Employee(4, "12345678", EmployeeRole.GENERAL_MANAGER));
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public ResponseEntity<Employee> getEmployeeById(long id) {
		for (Employee e:employees) {
			if (e.getEmployeeId() == id){
				return ResponseEntity.ok(e);
			}
		}
		return ResponseEntity.notFound().build();
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}


}
