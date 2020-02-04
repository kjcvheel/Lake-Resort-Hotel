package com.capgemini.molvenoresort.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
public class Employee extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeId;

	@NotNull
	private EmployeeRole role;

	//private String photo;


	public Employee(){}

	public Employee(long employeeId, String password, EmployeeRole role) {
		super(password);
		this.employeeId = employeeId;
		this.role = role;
	}

	public Employee(long employeeId, String password, EmployeeRole role, String firstName, String lastName, Date birthday, String country, String city, String address, String zipcode, String phoneNumber, String mobileNumber, String photo, String email) {
		super(firstName, lastName, birthday, country, city, address, zipcode, phoneNumber, mobileNumber, password, email);
		//this.photo = photo;
		this.employeeId = employeeId;
		this.role = role;
	}

/*	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}*/

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeRole getRole() {
		return role;
	}

	public void setRole(EmployeeRole role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return employeeId == employee.employeeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}
}
