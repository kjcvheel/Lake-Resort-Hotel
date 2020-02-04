package com.capgemini.molvenoresort.booking;

import com.capgemini.molvenoresort.room.MockRoomDB;
import com.capgemini.molvenoresort.room.Room;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

@RestController
@RequestMapping(value = {"/bookings", "/Bookings"})
public class BookingController {

    @Autowired
    private bookingRepository repository;


    @GetMapping
    public Iterable<Booking>getAllBookings() {
        return this.repository.findAll();
    }

    @GetMapping("/booking{id}")
    public ResponseEntity<Booking> findById(@PathVariable long id) {
        Optional<Booking>temp = repository.findById(id);

        return temp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/guest{id}")
    public ResponseEntity<Iterable<Booking>> getBookingByGuestID(@PathVariable long id) {
        Iterable<Booking>temp = repository.findByBookingByGuestId(id);
        return ResponseEntity.ok(temp);
    }


    @PostMapping("/add")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(repository.save(booking));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    private ResponseEntity doesBookingExist(long id){
        return ResponseEntity.ok(repository.findById(id).isPresent());
    }

/*    private void addRoomsToBooking(Booking booking){

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
*/

}

