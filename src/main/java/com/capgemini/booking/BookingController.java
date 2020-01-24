package com.capgemini.booking;

import com.capgemini.room.MockRoomDB;
import com.capgemini.room.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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
    public Booking getBookingByID(@PathVariable int id) {
        return MockBookingDB.getInstance().getBookingByID(id);
    }

    @GetMapping("/guest{id}")
    public Booking getBookingByGuestID(@PathVariable int id) {
        return MockBookingDB.getInstance().getBookingByGuestID(id);
    }

    @GetMapping("/add/{id}")
    public String addBooking(@PathVariable int id) {
        Booking newBooking = createBooking(id);
        if(newBooking != null) {
            addRoomsToBooking(newBooking);
            MockBookingDB.getInstance().addBooking(newBooking);
            return ("Booking has been added, your booking ID is " + id);
        }
        else{
            return "Booking already exists, nothing was added";
            //throw new NullPointerException();

        }
    }

    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable int id) {
        Booking booking = getBookingByID(id);
        if(booking != null) {
            MockBookingDB.getInstance().deleteBooking(booking);
            return "Booking with ID " + id + " has been deleted";
        }
        else {
            return "Booking does not exist, nothing was deleted";
        }
    }

    private Booking createBooking(int id) {
        if(!doesBookingExist(id))
            return new Booking(id, 356, LocalDate.now(), LocalDate.of(2020, 1, 28));

        return null;
    }

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

