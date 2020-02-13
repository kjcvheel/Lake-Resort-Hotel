package com.capgemini.molvenoresort.services;

import com.capgemini.molvenoresort.models.Booking;
import com.capgemini.molvenoresort.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    public Iterable<Booking>findAll() {
        return this.repository.findAll();
    }

    public ResponseEntity<Booking> findById(long id) {
        Optional<Booking> temp = repository.findById(id);
        return temp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity deleteById(long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity doesBookingExist(long id) {
        return ResponseEntity.ok(repository.findById(id).isPresent());
    }


    public ResponseEntity<?> addBooking(Booking booking) {
        if (checkAge(booking))
        {
            System.out.println("TESTING FROM SERVICE");
            return ResponseEntity.ok(repository.save(booking));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("To young");
        }

    }

    public ResponseEntity<Booking> updateBooking(Booking booking) {
        return ResponseEntity.ok(repository.save(booking));
    }

    public boolean checkAge(Booking booking) {
        Calendar calender = GregorianCalendar.getInstance();
        calender.set(Calendar.YEAR, calender.get(Calendar.YEAR)-18);
        System.out.println("Checking");
//        Date temp = booking.getGuestID().getBirthday();
        return calender.getTime().after(booking.getMainBooker().getBirthday());
    }
}
