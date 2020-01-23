package com.capgemini.booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockBookingDB {
    private static com.capgemini.booking.MockBookingDB bookingDB = null;
    private static List<Booking> bookings = new ArrayList<>();

    private MockBookingDB(){
        fillBookingTable();
    }

    public static com.capgemini.booking.MockBookingDB getInstance(){
        if(bookingDB == null)
            bookingDB = new com.capgemini.booking.MockBookingDB();

        return bookingDB;
    }

    private void fillBookingTable(){
        bookings.add(new Booking(45, 35, LocalDate.of(2020, 5, 15), LocalDate.of(2020, 5, 20)));
        bookings.add(new Booking(48, 113, LocalDate.of(2020, 9, 24), LocalDate.of(2020, 9, 25)));
        bookings.add(new Booking(69, 34, LocalDate.of(2020, 6, 15), LocalDate.of(2020, 6, 18)));
        bookings.add(new Booking(123, 98, LocalDate.of(2020, 3, 1), LocalDate.of(2020, 3, 25)));
    }

    public List<Booking> getBookings(){return bookings;}

    public Booking getBookingByID(int id){
        for(Booking booking: bookings){
            if(booking.getId() == id)
                return booking;
        }

        return null;
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    public void deleteBooking(int index){bookings.remove(index);}




}
