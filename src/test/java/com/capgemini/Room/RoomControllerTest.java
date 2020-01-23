package com.capgemini.Room;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class RoomControllerTest {
    RoomController roomController;
    int numberOfRooms = 0;

    @Before
    public void Before() {
        roomController = new RoomController();
        numberOfRooms = MockRoomDB.getInstance().getRooms().size();
    }

    @Test
    public void getRoomsTest() {
        List<Room> rooms = roomController.showRooms();
        assertEquals(numberOfRooms, rooms.size());
        assertEquals( "Suite 02", rooms.get(0).getId());
    }

    @Test
    public void addRoomTest() {
        roomController.addRoom("Klaas");
        List<Room> rooms = roomController.showRooms();
        assertEquals("Klaas", rooms.get(4).getId());
        assertEquals(numberOfRooms+1, rooms.size());

    }
}
