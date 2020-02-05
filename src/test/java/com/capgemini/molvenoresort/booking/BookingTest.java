package com.capgemini.molvenoresort.booking;


import com.capgemini.molvenoresort.booking.Booking;
import com.capgemini.molvenoresort.booking.BookingStatus;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class BookingTest {
    Booking booking;

/*    @Before
    public void before() {
        booking = new Booking(45, 35, LocalDate.of(2020, 5, 15), LocalDate.of(2020, 5, 20));
    }

    @Test
    public void createBookingTest() {
        // Happy Path
        booking = new Booking(45, 35, LocalDate.of(2020, 5, 15), LocalDate.of(2020, 5, 20));
        assertEquals(45, booking.getId());
        assertEquals(35, booking.getGuestID());
        assertEquals(LocalDate.of(2020,5,15), booking.getStartDate());
        assertEquals(LocalDate.of(2020,5,20), booking.getEndDate());


        // TODO: Unhappy Path
    }

    @Test
    public void bookingStatusTest() {
        // Reserved
        assertEquals(BookingStatus.RESERVED, booking.getStatus());

        // Booked
        booking.setStatus(BookingStatus.BOOKED);
        assertEquals(BookingStatus.BOOKED, booking.getStatus());

        // Checked in
        booking.setStatus(BookingStatus.CHECKED_IN);
        assertEquals(BookingStatus.CHECKED_IN, booking.getStatus());

        // Checked out
        booking.setStatus(BookingStatus.CHECKED_OUT);
        assertEquals(BookingStatus.CHECKED_OUT, booking.getStatus());
    }*/
}
