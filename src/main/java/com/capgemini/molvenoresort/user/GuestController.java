package com.capgemini.molvenoresort.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/guests")
public class GuestController {
	@Autowired
	GuestRepository guestRepository;

	@GetMapping
	public List<Guest> getGuests() {
		return (ArrayList)guestRepository.findAll();
	}

	@PostMapping("/add")
	public ResponseEntity<Guest> addGuest(@RequestBody Guest guest) {
		return ResponseEntity.ok(guestRepository.save(guest));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
		Optional<Guest> result = guestRepository.findById(id);
		return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
}
