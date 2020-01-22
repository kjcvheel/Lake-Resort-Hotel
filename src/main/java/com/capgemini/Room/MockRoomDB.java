package com.capgemini.Room;

import java.util.ArrayList;
import java.util.List;

public class MockRoomDB {
    private static MockRoomDB roomDB = null;
    private static List<Room> rooms = new ArrayList<>();
    public String s;

    private MockRoomDB() {
        fillRoomTable();
    }

    public static MockRoomDB getInstance() {
        if (roomDB == null) {
            roomDB = new MockRoomDB();
        }

        return roomDB;
    }

    private void fillRoomTable() {
        rooms.add(new Room("Suite 02", 400, 102, RoomType.Double));
        rooms.add(new Room("Suite 34", 600, 134, RoomType.Single));
        rooms.add(new Room("Suite 127", 550, 227, RoomType.Doublex2));
        rooms.add(new Room("Penthouse 1", 6000, 358, RoomType.Penthouse));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(String id) {
        rooms.add(new Room(id, 500, 102, RoomType.Single));
    }

    public void deleteRoom(int index) {
        rooms.remove(index);
    }
}
