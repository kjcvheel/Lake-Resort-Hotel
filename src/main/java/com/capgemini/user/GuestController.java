package com.capgemini.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {
	@GetMapping
	public List<Guest> getGuests() {
		return MockGuestDB.getInstance().getGuests();
	}

	@GetMapping("/guests/add/{id}")
	public void addGuest(@PathVariable String id) {
		MockGuestDB.getInstance().addGuest(id, "qwertyy");
	}
}
