package com.capgemini.booking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Bookings")
public class BookingController {

    public BookingController() {
        //Initialize the booking controller
    }

    @GetMapping
    public List<Booking> getBookings() {
        return MockBookingDB.getInstance().getBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingByID(@PathVariable int id) {
        return MockBookingDB.getInstance().getBookingByID(id);
    }

    @GetMapping("/add/{id}")
    public void addBooking(@PathVariable int id) {
        Booking newBooking = createBooking(id);
        addRoomsToBooking(newBooking);
        MockBookingDB.getInstance().addBooking(newBooking);
    }

    private Booking createBooking(int id) {
        return new Booking(id, 356, LocalDate.now(), LocalDate.of(2020, 1, 28));
    }

    private void addRoomsToBooking(Booking booking){
        List<Integer> rooms = new ArrayList<>();
        rooms.add(45);
        rooms.add(200);
        booking.setRoomNumbers(rooms);
    }


}

