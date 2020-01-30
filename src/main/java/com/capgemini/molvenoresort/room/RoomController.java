package com.capgemini.molvenoresort.room;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"api/rooms", "api/Rooms"})
public class RoomController {

    public RoomController() {
        // Initialize RoomController
    }

    @GetMapping
    public List<Room> showRooms() {
        return MockRoomDB.getInstance().getRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable String id){
        Room room = MockRoomDB.getInstance().getRoomById(id);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(room);
    }

    @PostMapping("/add")
    public String addRoom(@RequestBody Room room) {
       MockRoomDB.getInstance().addRoom(room);
       return ("Room has been added, your room ID is " + room.getId());
    }

    @GetMapping("/under{id}")
    public List<Room> roomsUnder(@PathVariable int id) {
        return MockRoomDB.getInstance().getRoomsUnder(id);
    }

    @GetMapping("/under{id}/Single")
    public List<Room> singleRoomsUnder(@PathVariable int id) {
        return MockRoomDB.getInstance().getSingleRoomsUnder(id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Room> deleteById(@PathVariable String id) {
        for(Room room : MockRoomDB.getInstance().getRooms()) {
            if(id.equals(room.getId())) {
                // NB: You have to override equals and hashCode in Printer to do this correctly!!!
                MockRoomDB.getInstance().deleteRoom(room);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
