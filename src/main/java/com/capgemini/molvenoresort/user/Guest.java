package com.capgemini.molvenoresort.user;

import com.capgemini.molvenoresort.booking.Booking;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Guest extends User {

	@Column
	@NotNull
	private int creditcard;

	@Column
	@OneToMany(mappedBy = "mainBooker")
	private List<Booking> bookings;

	public Guest() {
		setPassword("default");
		bookings = new ArrayList<Booking>();
	}

	public Guest(String password) {
		super(password);
		bookings = new ArrayList<Booking>();
	}

	public Guest(long id,  String password, String firstName, String lastName, Date birthday, String country, String city, String address, String zipcode, String phoneNumber, String mobileNumber, int creditcard, String email) {
		super(id, firstName, lastName, birthday, country, city, address, zipcode, phoneNumber, mobileNumber, password, email);
		this.creditcard = creditcard;
		bookings = new ArrayList<Booking>();
	}

	public int getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(int creditcard) {
		this.creditcard = creditcard;
	}

	public long getGuestId() {
		return id;
	}

}
