package com.capgemini.molvenoresort.booking;

import com.capgemini.molvenoresort.room.MockRoomDB;
import com.capgemini.molvenoresort.room.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = {"/bookings", "/Bookings"})
public class BookingController {

    public BookingController() {
        //Initialize the booking controller
    }

    @GetMapping
    public List<Booking> getBookings() {
        return MockBookingDB.getInstance().getBookings();
    }

    @GetMapping("/booking{id}")
    public ResponseEntity<Booking> getBookingByID(@PathVariable int id) {
        return MockBookingDB.getInstance().getBookingByID(id);
    }

    @GetMapping("/guest{id}")
    public ResponseEntity<Booking> getBookingByGuestID(@PathVariable int id) {
        return MockBookingDB.getInstance().getBookingByGuestID(id);
    }


    @PostMapping("/add")
    public String addBooking(@RequestBody Booking booking) {
        if(!doesBookingExist(booking.getId())) {
            addRoomsToBooking(booking);
            MockBookingDB.getInstance().addBooking(booking);
            return ("Booking has been added, your booking ID is " + booking.getId());
        }
        else{
            return "Booking already exists, nothing was added";
            //throw new NullPointerException();

        }
    }
/*
    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable int id) {

        Booking booking = getBookingByID(id).getBody();
        if(booking != null) {
            MockBookingDB.getInstance().deleteBooking(booking);
            return "Booking with ID " + id + " has been deleted";
        }
        else {
            return "Booking does not exist, nothing was deleted";
        }
    }*/



    private boolean doesBookingExist(int id){
        for (Booking booking: MockBookingDB.getInstance().getBookings()) {
            if (booking.getId() == id)
                return true;
        }
        return false;
    }

    private void addRoomsToBooking(Booking booking){
        List<Integer> rooms = new ArrayList<>();
        if(doesRoomExist(102))
            rooms.add(102);
        if(doesRoomExist(200))
            rooms.add(200);
        booking.setRoomNumbers(rooms);
    }

    private boolean doesRoomExist(int roomNumber){
        for (Room room: MockRoomDB.getInstance().getRooms()) {
            if (room.getNumber() == roomNumber)
                return true;
        }
        return false;

    }


}

