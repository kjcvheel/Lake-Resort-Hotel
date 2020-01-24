package com.capgemini.booking;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BookingControllerTest {

    BookingController bookingController;
    int numberOfBookings = 0;


    @Rule
    public final ExpectedException exception = ExpectedException.none();

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

    @Test
    public void getBookingByID() {
        //Valid booking
        Booking booking = bookingController.getBookingByID(45);
        assertEquals(45, booking.getId());

        //Invalid booking
        assertNull(bookingController.getBookingByID(-30));
    }

    @Test
    public void getBookingByGuestID() {
        //Valid booking
        Booking booking = bookingController.getBookingByGuestID(34);
        assertEquals(34, booking.getGuestID());

        //Invalid booking
        assertNull(bookingController.getBookingByGuestID(-40));
    }


    @Test
    public void addBooking() {
        //Add valid booking
        bookingController.addBooking(90);
        assertEquals(90, bookingController.getBookingByID(90).getId());

        //Add already existing booking number
        exception.expect(NullPointerException.class);
        bookingController.addBooking(90);
    }



    @Test
    public void deleteBooking() {
        bookingController.deleteBooking(45);
        assertNull(bookingController.getBookingByID(45));
    }
}
