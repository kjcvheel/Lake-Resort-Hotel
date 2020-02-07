package com.capgemini.molvenoresort.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
public  abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	protected Long id;


	@Column
	@NotNull
	private String firstName;

	@Column
	@NotNull
	private String lastName;

	@Column
	private String email;

	@Column
	@NotNull
	private String password;

	@Column
	private Date birthday;
	@Column
	private String country;
	@Column
	private String city;
	@Column
	private String address;
	@Column
	private String zipcode;
	@Column
	private String phoneNumber;
	@Column
	private String mobileNumber;


	public User(){}
	public User(String password) {
		this.password = password;
	}

	public User(long id, String firstName, String lastName, Date birthday, String country, String city, String address, String zipcode, String phoneNumber, String mobileNumber, String password, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.country = country;
		this.city = city;
		this.address = address;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.matches("[a-zA-Z' ]+")) {
			this.firstName = firstName;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.matches("[a-zA-Z' ]+")) {
			this.lastName = lastName;
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
