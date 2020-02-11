package com.capgemini.molvenoresort.api;


import com.capgemini.molvenoresort.filter.Filter;
import com.capgemini.molvenoresort.models.Booking;
import com.capgemini.molvenoresort.models.Room;
import com.capgemini.molvenoresort.repositories.BookingRepository;
import com.capgemini.molvenoresort.repositories.RoomRepository;
import com.capgemini.molvenoresort.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = {"api/rooms", "api/Rooms"})
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public RoomController() {
        // Initialize RoomController
    }

    @GetMapping
    public Iterable<Room> getRooms() {
        return this.roomRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable long id){
        Optional<Room> room = this.roomRepository.findById(id);
        if (room.isPresent()) {
            return ResponseEntity.ok(room.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
       return ResponseEntity.ok(this.roomRepository.save(room));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        System.out.println("Updateing room");
        return ResponseEntity.ok(this.roomRepository.save(room));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteById(@PathVariable long id) {
        this.roomRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //FILTERS
    @GetMapping("/under{id}")
    public Iterable<Room> roomsUnder(@PathVariable int id) {
        return this.roomRepository.findByPriceLessThanEqual(id);
    }

    @GetMapping("/date/{yr}/{mm}/{dd}/{yro}/{mmo}/{ddo}")
    public Iterable<Room> roomsByDate(@PathVariable("yr") int yr, @PathVariable("mm") int mm, @PathVariable("dd") int dd,
                                      @PathVariable("yro") int yro, @PathVariable("mmo") int mmo, @PathVariable("ddo") int ddo) {
        List<Room> notAvailable = new ArrayList<>();
        LocalDate checkin = LocalDate.of(yr, mm, dd);
        LocalDate checkout = LocalDate.of(yro, mmo, ddo);
        List<Booking> bookings = this.bookingRepository.findByStartDateLessThanAndEndDateGreaterThan(checkout, checkin);
        for(Booking booking: bookings){
            for (Room room : booking.getRoomNumbers()){
                if (!notAvailable.contains(room))
                    notAvailable.add(room);
            }
        }
        return notAvailable;
    }

    @PostMapping("/filter")
    public Iterable<Room> filteredRooms(@RequestBody Filter filter){
        List<Room> suitable;
        Iterable<Room> iterable = this.roomRepository.findAll();
        List<Room> rooms = new ArrayList<>();
        iterable.forEach(rooms::add);
        List<Room> temp;

/*        Collection<Room> tempRooms = (Collection<Room>) this.roomRepository.findAll();

        if (filter.isDisabled()){
            suitable = roomRepository.findByDisabledTrue().stream().filter(s -> tempRooms.contains(s)).collect(Collectors.toList());
        }*/

        if(filter.isDisabled()){
            suitable = this.roomRepository.findByDisabledTrue();
            temp = new ArrayList<>();
            for(Room room : suitable){
                if(rooms.contains(room)){
                    temp.add(room);
                }
            }
            rooms = temp;
        }
        if(filter.isSmoking()){
            suitable = this.roomRepository.findBySmokingTrue();
            temp = new ArrayList<>();
            for( Room room: suitable){
                if(rooms.contains(room)){
                    temp.add(room);
                }
            }
            rooms = temp;

        }

        suitable = this.roomRepository.findByPriceLessThanEqualAndAdultGreaterThanEqualAndChildrenGreaterThanEqual(filter.getMaxPrice(), filter.getAdult(), filter.getChildren());
        temp = new ArrayList<>();
        for (Room room : suitable) {
            if (rooms.contains(room)) {
                temp.add(room);
            }
        }
        rooms = temp;

        return rooms;
    }


}

