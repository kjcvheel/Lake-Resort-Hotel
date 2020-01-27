package com.capgemini.molvenoresort.user;

import java.util.Date;

public class Employee extends User {
	private String photo;
	private String employeeId; // or int
	private EmployeeRole role;

	public Employee(String employeeId, String password, EmployeeRole role) {
		super(password);
		this.employeeId = employeeId;
		this.role = role;
	}

	public Employee(String employeeId, String password, EmployeeRole role, String firstName, String lastName, Date birthday, String country, String city, String address, String zipcode, String phoneNumber, String mobileNumber, String photo) {
		super(firstName, lastName, birthday, country, city, address, zipcode, phoneNumber, mobileNumber, password);
		this.photo = photo;
		this.employeeId = employeeId;
		this.role = role;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeRole getRole() {
		return role;
	}

	public void setRole(EmployeeRole role) {
		this.role = role;
	}
}
