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

import javax.mail.MessagingException;
import javax.management.Notification;

@RestController
@RequestMapping(value = {"/bookings"})
public class BookingController {

    private String confirmationString = "Your booking has been processed into the system. For any questions please call our reception with the your booking id. Your booking ID is: ";
    private Logger logger = LoggerFactory.getLogger(BookingController.class);
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private BookingService bookingService;

    @GetMapping()
    public Iterable<Booking> getAllBookings() {
        return this.bookingService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable long id) {
        return bookingService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBooking(@RequestBody Booking booking) {
        ResponseEntity<?> temp = bookingService.addBooking(booking);

        String[] to = {booking.getMainBooker().getEmail()};
        try {
            notificationService.sendFromGMail(to, "Booking Confirmation", this.confirmationString + " " + booking.getId());
        }
        catch (MessagingException e) {
            System.out.println("error in sending mail" + e.getMessage());
        }
        return temp;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBooking(@RequestBody Booking booking) {
        return bookingService.updateBooking(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable long id) {
        return bookingService.deleteById(id);
    }

    private ResponseEntity doesBookingExist(long id){
        return bookingService.doesBookingExist(id);
    }



}

