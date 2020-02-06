package com.capgemini.molvenoresort.room;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Iterable<Room> rooms = this.roomRepository.findAll();
        System.out.println(rooms);
        return this.roomRepository.findAll();
        //return this.roomRepository.getRooms();
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
       //return ("Room has been added, your room ID is " + room.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        System.out.println("Updateing room");
        return ResponseEntity.ok(this.roomRepository.save(room));
        //return ("Room has been added, your room ID is " + room.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteById(@PathVariable long id) {
        this.roomRepository.deleteById(id);
        /*Optional<Long> deletedID = this.roomRepository.deleteById(id);
        if(deletedID.isPresent()){
                return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();*/
        return ResponseEntity.noContent().build();
    }

    //FILTERS
    /*@GetMapping("/under{id}")
    public Iterable<Room> roomsUnder(@PathVariable int id) {
        return this.roomRepository.getRoomsUnder(id);
    }

    @GetMapping("/under{id}/Single")
    public Iterable<Room> singleRoomsUnder(@PathVariable int id) {
        return this.roomRepository.getSingleRoomsUnder(id);
    }*/

}

