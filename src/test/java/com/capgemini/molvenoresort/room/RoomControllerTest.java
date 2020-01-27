package com.capgemini.molvenoresort.room;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoomControllerTest {
    RoomController roomController;
    int numberOfRooms = 0;

    @Before
    public void before() {
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
        Room room = new Room("Klaas", 500, 501, RoomType.SINGLE);
        roomController.addRoom(room);
        List<Room> rooms = roomController.showRooms();
        assertEquals("Klaas", rooms.get(numberOfRooms).getId());
        assertEquals(numberOfRooms+1, rooms.size());

    }

    @Test
    public void roomsUnderTest() {
        List<Room> rooms;
        int[] amountsToTest = new int[] {580, 300, 99999, -500};
        int[] roomsPerAmount = new int[] {2, 0, 5, 0};
        for (int i = 0; i < amountsToTest.length; i++) {
            rooms = roomController.roomsUnder(amountsToTest[i]);
            assertEquals(roomsPerAmount[i], rooms.size());
            for (Room room:rooms) {
                assertTrue(room.getPrice() <= amountsToTest[i]);
            }
        }
    }

    @Test
    public void singleRoomsUnderTest() {
        List<Room> rooms;
        int[] amountsToTest = new int[] {710, 690, 300, -500};
        int[] roomsPerAmount = new int[] {2, 1, 0, 0};
        for (int i = 0; i < amountsToTest.length; i++) {
            rooms = roomController.singleRoomsUnder(amountsToTest[i]);
            assertEquals(roomsPerAmount[i], rooms.size());
            for (Room room:rooms) {
                assertEquals(RoomType.SINGLE, room.getType());
                assertTrue(room.getPrice() <= amountsToTest[i]);
            }
        }
    }
}
