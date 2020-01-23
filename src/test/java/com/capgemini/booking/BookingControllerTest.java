package com.capgemini.booking;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookingControllerTest {

    BookingController bookingController;
    int numberOfBookings = 0;

    @Before
    public void before() {
        bookingController = new BookingController();
        numberOfBookings = MockBookingDB.getInstance().getBookings().size();
    }

    @Test
    public void getBookingsTest() {
        List<Booking> bookings = bookingController.getBookings();
        assertEquals(numberOfBookings, bookings.size());
        assertEquals( 45, bookings.get(0).getId());
    }
}
