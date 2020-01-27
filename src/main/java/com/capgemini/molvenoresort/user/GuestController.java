package com.capgemini.molvenoresort.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {
	@GetMapping
	public List<Guest> getGuests() {
		return MockGuestDB.getInstance().getGuests();
	}

	@PostMapping("/add")
	public String addGuest(@RequestBody Guest guest) {
		MockGuestDB.getInstance().addGuest(guest);
		return ("Guest has been added");

	}

	@GetMapping("/{id}")
	public ResponseEntity<Guest> getGuestById(@PathVariable String id) {
		return MockGuestDB.getInstance().getGuestById(id);
	}

}
