package com.capgemini.molvenoresort.user;

import java.util.Date;

public class Guest extends User {
	private int creditcard;
	private long guestId; // Could also be an int.

	public Guest(){}

	public Guest(long guestId, String password) {
		super(password);
		this.guestId = guestId;
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
