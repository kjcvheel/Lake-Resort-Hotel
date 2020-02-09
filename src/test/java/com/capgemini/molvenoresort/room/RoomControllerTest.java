package com.capgemini.molvenoresort.room;

import com.capgemini.molvenoresort.controllers.RoomController;
import com.capgemini.molvenoresort.enums.RoomType;
import com.capgemini.molvenoresort.models.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoomControllerTest {
    RoomController roomController;
    int numberOfRooms = 0;

    @Before
    public void before() {
        roomController = new RoomController();
        numberOfRooms = 5;
    }

    @Test
    public void getRoomsTest() {
        Iterable<Room> rooms = roomController.getRooms();
        assertEquals(numberOfRooms, ((Collection<?>) rooms).size());
    }

    @Test
    public void addRoomTest() {
        Room room = new Room("Klaas", 500, 501, RoomType.SINGLE);
        roomController.addRoom(room);
        Iterable<Room> rooms = roomController.getRooms();

        assertEquals(numberOfRooms+1, ((Collection<?>) rooms).size());

    }

    /*@Test
    public void roomsUnderTest() {
        Iterable<Room> rooms;
        int[] amountsToTest = new int[] {580, 300, 99999, -500};
        int[] roomsPerAmount = new int[] {2, 0, 5, 0};
        for (int i = 0; i < amountsToTest.length; i++) {
            rooms = roomController.roomsUnder(amountsToTest[i]);
            assertEquals(roomsPerAmount[i], ((Collection<?>) rooms).size());
            for (Room room:rooms) {
                assertTrue(room.getPrice() <= amountsToTest[i]);
            }
        }
    }

    @Test
    public void singleRoomsUnderTest() {
        Iterable<Room> rooms;
        int[] amountsToTest = new int[] {710, 690, 300, -500};
        int[] roomsPerAmount = new int[] {3, 2, 0, 0};
        for (int i = 0; i < amountsToTest.length; i++) {
            rooms = roomController.singleRoomsUnder(amountsToTest[i]);
            assertEquals(roomsPerAmount[i], ((Collection<?>) rooms).size());
            for (Room room:rooms) {
                assertEquals(RoomType.SINGLE, room.getType());
                assertTrue(room.getPrice() <= amountsToTest[i]);
            }
        }
    }*/
}
