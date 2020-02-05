package com.capgemini.molvenoresort.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Guest extends User {

	@Column
	@NotNull
	private int creditcard;

	public Guest(){}

	public Guest(String password) {
		super(password);
	}

	public Guest(long id,  String password, String firstName, String lastName, Date birthday, String country, String city, String address, String zipcode, String phoneNumber, String mobileNumber, int creditcard, String email) {
		super(id, firstName, lastName, birthday, country, city, address, zipcode, phoneNumber, mobileNumber, password, email);
		this.creditcard = creditcard;
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
