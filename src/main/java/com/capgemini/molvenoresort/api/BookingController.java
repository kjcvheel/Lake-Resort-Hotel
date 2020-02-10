package com.capgemini.molvenoresort.api;

import com.capgemini.molvenoresort.models.Booking;
import com.capgemini.molvenoresort.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/bookings"})
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @GetMapping()
    public Iterable<Booking> getAllBookings() {
        return this.bookingService.findAll();
    }

    @GetMapping("/booking{id}")
    public ResponseEntity<Booking> findById(@PathVariable long id) {
        return bookingService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBooking(@RequestBody Booking booking) {
        System.out.println("TESTINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
        return bookingService.addBooking(booking);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable long id) {
        return bookingService.deleteById(id);
    }

    private ResponseEntity doesBookingExist(long id){
        return bookingService.doesBookingExist(id);
    }



}

