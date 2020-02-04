package com.capgemini.molvenoresort.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Guest extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long guestId;

	private int creditcard;

	public Guest(){}

	public Guest(String password) {
		super(password);
		//this.guestId = guestId;
	}

	public Guest(long guestId,  String password, String firstName, String lastName, Date birthday, String country, String city, String address, String zipcode, String phoneNumber, String mobileNumber, int creditcard, String email) {
		super(firstName, lastName, birthday, country, city, address, zipcode, phoneNumber, mobileNumber, password, email);
		this.creditcard = creditcard;
		this.guestId = guestId;
	}

	public int getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(int creditcard) {
		this.creditcard = creditcard;
	}

	public long getGuestId() {
		return guestId;
	}

	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}
}
