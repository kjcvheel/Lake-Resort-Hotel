package com.capgemini.molvenoresort.room;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"api/rooms", "api/Rooms"})
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    public RoomController() {
        // Initialize RoomController
    }

    @GetMapping
    public Iterable<Room> getRooms() {
        return this.roomRepository.getRooms();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable long id){
        Optional<Room> room = this.roomRepository.getRoomById(id);
        if (room.isPresent()) {
            return ResponseEntity.ok(room.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/under{id}")
    public Iterable<Room> roomsUnder(@PathVariable int id) {
        return this.roomRepository.getRoomsUnder(id);
    }

    @GetMapping("/under{id}/Single")
    public Iterable<Room> singleRoomsUnder(@PathVariable int id) {
        return this.roomRepository.getSingleRoomsUnder(id);
    }

    @PostMapping("/add")
    public String addRoom(@RequestBody Room room) {
       this.roomRepository.addRoom(room);
       return ("Room has been added, your room ID is " + room.getId());
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Room> deleteById(@PathVariable long id) {
        Optional<Long> deletedID = this.roomRepository.deleteRoom(id);
        if(deletedID.isPresent()){
                return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

