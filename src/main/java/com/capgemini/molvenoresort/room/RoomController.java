package com.capgemini.molvenoresort.room;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/rooms", "/Rooms"})
public class RoomController {

    public RoomController() {
        // Initialize RoomController
    }

    @GetMapping
    public List<Room> showRooms() {
        return MockRoomDB.getInstance().getRooms();
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
}
