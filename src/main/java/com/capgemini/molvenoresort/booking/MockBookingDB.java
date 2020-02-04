package com.capgemini.molvenoresort.booking;

import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockBookingDB {
    private static MockBookingDB bookingDB = null;
    private static List<Booking> bookings = new ArrayList<>();
    private static int counter = 0;

    private MockBookingDB(){
        fillBookingTable();
    }

    public static MockBookingDB getInstance(){
        if(bookingDB == null)
            bookingDB = new MockBookingDB();

        return bookingDB;
    }

    private void fillBookingTable(){
        bookings.add(new Booking(45, 35, LocalDate.of(2020, 5, 15), LocalDate.of(2020, 5, 20)));
        bookings.add(new Booking(48, 113, LocalDate.of(2020, 9, 24), LocalDate.of(2020, 9, 25)));
        bookings.add(new Booking(69, 34, LocalDate.of(2020, 6, 15), LocalDate.of(2020, 6, 18)));
        bookings.add(new Booking(123, 98, LocalDate.of(2020, 3, 1), LocalDate.of(2020, 3, 25)));
    }

    public List<Booking> getBookings(){return bookings;}

    public ResponseEntity<Booking> getBookingByID(int id){
        for(Booking booking: bookings){
            if(booking.getId() == id)
                return ResponseEntity.ok(booking);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Booking> getBookingByGuestID(int id){
        for(Booking booking: bookings){
            if(booking.getGuestID() == id)
                return ResponseEntity.ok(booking);
        }

        return ResponseEntity.notFound().build();
    }

    public void addBooking(Booking booking){
        booking.setId(++counter);
        bookings.add(booking);
    }

    public void deleteBooking(Booking booking){bookings.remove(booking);}




}
