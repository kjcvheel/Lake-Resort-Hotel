package com.capgemini.molvenoresort.controllers;

import com.capgemini.molvenoresort.models.Guest;
import com.capgemini.molvenoresort.repositories.GuestRepository;
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

	@GetMapping("/{id}")
	public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
		Optional<Guest> result = guestRepository.findById(id);
		return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/add")
	public ResponseEntity<Guest> addGuest(@RequestBody Guest guest) {
		return ResponseEntity.ok(guestRepository.save(guest));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest) {
		return ResponseEntity.ok(this.guestRepository.save(guest));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Guest> deleteGuest(@PathVariable long id) {
		this.guestRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
