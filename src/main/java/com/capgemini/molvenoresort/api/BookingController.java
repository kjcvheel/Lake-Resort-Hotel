package com.capgemini.molvenoresort.api;

import com.capgemini.molvenoresort.models.Booking;
import com.capgemini.molvenoresort.services.BookingService;
import com.capgemini.molvenoresort.services.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import javax.management.Notification;

@RestController
@RequestMapping(value = {"/bookings"})
public class BookingController {


    private Logger logger = LoggerFactory.getLogger(BookingController.class);
    @Autowired
    private NotificationService notificationService;
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
        ResponseEntity temp = bookingService.addBooking(booking);
        try {
            notificationService.sendNotification(booking.getMainBooker());
        }
        catch (MailException e) {
            System.out.println("error in sending mail" + e.getMessage());
        }
        return temp;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable long id) {
        return bookingService.deleteById(id);
    }

    private ResponseEntity doesBookingExist(long id){
        return bookingService.doesBookingExist(id);
    }



}

