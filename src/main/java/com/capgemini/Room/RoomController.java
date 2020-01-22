package com.capgemini.Room;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Rooms")
public class RoomController {

    public RoomController() {
    }

    @RequestMapping
    List<Room> showRooms() {
        return MockRoomDB.getInstance().getRooms();
    }

    @RequestMapping("/add/{id}")
    void addRoom(@PathVariable String id) {
        MockRoomDB.getInstance().addRoom(id);
    }

    @RequestMapping("/under600")
    List<Room> roomsUnder600() {
        return MockRoomDB.getInstance().getRoomsUnder600();
    }

    @RequestMapping("/under600/Single")
    List<Room> singleRoomsUnder600() {
        return MockRoomDB.getInstance().getSingleRoomsUnder600();
    }
}
