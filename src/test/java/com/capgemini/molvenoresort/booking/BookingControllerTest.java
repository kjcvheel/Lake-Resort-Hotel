package com.capgemini.molvenoresort.booking;

import com.capgemini.molvenoresort.booking.Booking;
import com.capgemini.molvenoresort.booking.BookingController;
import com.capgemini.molvenoresort.booking.MockBookingDB;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.http.ResponseEntity;

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
        Booking booking = bookingController.getBookingByID(45).getBody();
        assertEquals(45, booking.getId());

        //Invalid booking
        assertEquals(ResponseEntity.notFound().build(), bookingController.getBookingByID(-30));
    }

    @Test
    public void getBookingByGuestID() {
        //Valid booking
        Booking booking = bookingController.getBookingByGuestID(34).getBody();
        assertEquals(34, booking.getGuestID());

        //Invalid booking
        assertEquals(ResponseEntity.notFound().build(), bookingController.getBookingByGuestID(-40));
    }


    @Test
    public void addBooking() {
        Booking booking = new Booking();
        booking.setId(90);
        //Add valid booking
        bookingController.addBooking(booking);
        assertEquals(90, bookingController.getBookingByID(90).getBody().getId());

        //Add already existing booking number
        exception.expect(NullPointerException.class);
        bookingController.addBooking(booking);
    }

/*

    @Test
    public void deleteBooking() {
        bookingController.deleteBooking(45);
        assertNull(bookingController.getBookingByID(45));
    }*/
}
