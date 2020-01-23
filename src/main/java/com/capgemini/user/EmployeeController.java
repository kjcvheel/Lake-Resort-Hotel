package com.capgemini.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@GetMapping
	public List<Employee> getEmployees() {
		return MockEmployeeDB.getInstance().getEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return MockEmployeeDB.getInstance().getEmployeeById(id);
	}

	@GetMapping("/add/{id}/{password}")
	public void addEmployee(@PathVariable String id, @PathVariable String password) {
		MockEmployeeDB.getInstance().addEmployee(id, password);
	}
}
