package com.capgemini.User;

import java.util.Date;

public class Guest extends User {
	private int creditCard;
	private String guestId; // Could also be an int.

	public Guest(String guestId, String password) {
		super(password);
		this.guestId = guestId;
	}

	public Guest(String guestId,  String password, String firstName, String lastName, Date birthday, String country, String city, String address, String zipcode, String phoneNumber, String mobileNumber, int creditCard) {
		super(firstName, lastName, birthday, country, city, address, zipcode, phoneNumber, mobileNumber, password);
		this.creditCard = creditCard;
		this.guestId = guestId;
	}

	public int getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

	public String getGuestId() {
		return guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
}
