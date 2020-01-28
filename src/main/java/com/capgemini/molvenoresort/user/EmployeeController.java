package com.capgemini.molvenoresort.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@GetMapping
	public List<Employee> getEmployees() {
		return MockEmployeeDB.getInstance().getEmployees();
	}



	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
		return MockEmployeeDB.getInstance().getEmployeeById(id);
	}



	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee employee) {
		MockEmployeeDB.getInstance().addEmployee(employee);
		return ("Employee has been added");

	}
}
