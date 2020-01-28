package com.capgemini.room;

import java.util.ArrayList;
import java.util.List;

public class MockRoomDB {
    private static MockRoomDB roomDB = null;
    private static List<Room> rooms = new ArrayList<>();

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
        rooms.add(new Room("Suite 02", 400, 102, RoomType.DOUBLE));
        rooms.add(new Room("Suite 34", 600, 134, RoomType.SINGLE));
        rooms.add(new Room("Suite 87", 700, 222, RoomType.SINGLE));
        rooms.add(new Room("Suite 127", 550, 227, RoomType.DOUBLEX_2));
        rooms.add(new Room("Penthouse 1", 6000, 358, RoomType.PENTHOUSE));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(String id) {
        rooms.add(new Room(id, 9999999, 102, RoomType.SINGLE));
    }

    public void deleteRoom(int index) {
        rooms.remove(index);
    }

    public List<Room> getRoomsUnder(int price){
        List<Room> cheapRooms = new ArrayList<>();
        for (Room room : rooms){
            if(room.getPrice()<=price)
                cheapRooms.add(room);
        }
        return cheapRooms;
    }

    public List<Room> getSingleRoomsUnder(int price){
        List<Room> cheapSingleRooms = new ArrayList<>();
        for (Room room : rooms){
            if(room.getPrice()<=price && room.getType()==RoomType.SINGLE)
                cheapSingleRooms.add(room);
        }
        return cheapSingleRooms;
    }

    //findByStatusAndPriceLessThanEqual(RoomStatus status, int maxPrice)
    //findByStatusAndPriceBetween(RoomStatus status, int minPrice, int maxPrice)
    //findByStatusAndType(RoomStatus status, RoomType type)
    //FindByStatusAndAdultAndChildren(RoomStatus status, int adult, int children)
    //findByStatusAndDisabledTrue(RoomStatus status)
    //findByStatusAndSmokingTrue(RoomStatus status)
    //findByStatusAndSmokingFalse(RoomStatus status)

}