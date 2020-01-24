package com.capgemini.room;


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

    @GetMapping("/add/{id}")
    public void addRoom(@PathVariable String id) {
        MockRoomDB.getInstance().addRoom(id);
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
