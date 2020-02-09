package com.capgemini.molvenoresort.api;

import com.capgemini.molvenoresort.models.Booking;
import com.capgemini.molvenoresort.repositories.bookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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


/*    @GetMapping("/guest{id}")
    public ResponseEntity<Iterable<Booking>> getBookingByGuestID(@PathVariable long id) {
        Iterable<Booking>temp = repository.findByBookingByGuestId(id);
        return ResponseEntity.ok(temp);
    }*/


    @PostMapping("/add")
    public ResponseEntity<?> addBooking(@RequestBody Booking booking) {
        if (checkAge(booking))
        {
            return ResponseEntity.ok(repository.save(booking));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("To young");
        }

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

    private boolean doesRoomExist(long roomId){
        for (Room room: MockRoomDB.getInstance().getRooms()) {
            if (room.getId() == roomId )
                return true;
        }
        return false;

    }
*/

    public boolean checkAge(Booking booking) {
        Calendar calender = GregorianCalendar.getInstance();
        calender.set(Calendar.YEAR, calender.get(Calendar.YEAR)-18);
//        Date temp = booking.getGuestID().getBirthday();
        return calender.getTime().after(booking.getMainBooker().getBirthday());
    }
}

