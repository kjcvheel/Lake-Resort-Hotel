package com.capgemini.molvenoresort.repositories;

import com.capgemini.molvenoresort.models.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findByPriceLessThanEqual(int price);

    List<Room> findByDisabledTrue();

    List<Room> findBySmokingTrue();

    List<Room> findByAdultGreaterThanEqual(int adult);

    List<Room> findByChildrenGreaterThanEqual(int children);

    List<Room> findByAdultGreaterThanEqualAndChildrenGreaterThanEqual(int adult, int children);

    List<Room> findByPriceLessThanEqualAndAdultGreaterThanEqualAndChildrenGreaterThanEqual(int price, int adult, int children);

   /* private List<Room> rooms = new ArrayList<>();

    public Iterable<Room> getRooms(){
        return rooms;
    }

    public Optional<Room> getRoomById(long id) {
        for (Room room : rooms){
            if (room.getId() ==id) {
                return Optional.of(room);
            }
        }
        return Optional.empty();
    }

    public Iterable<Room> getRoomsUnder(int price){
        List<Room> cheapRooms = new ArrayList<>();
        for (Room room : rooms){
            if(room.getPrice()<=price)
                cheapRooms.add(room);
        }
        return cheapRooms;
    }

    public Iterable<Room> getSingleRoomsUnder(int price){
        List<Room> cheapSingleRooms = new ArrayList<>();
        for (Room room : rooms){
            if(room.getPrice()<=price && room.getType()==RoomType.SINGLE)
                cheapSingleRooms.add(room);
        }
        return cheapSingleRooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Optional<Long> deleteRoom(long id) {
        for (Room room : rooms) {
            if (id == room.getId()){
                rooms.remove(room);
                return Optional.of(id);
            }
        }
        return Optional.empty();
    }



    @PostConstruct
    public void init(){
        {
            rooms.add(new Room("Suite 02", 400, 102, RoomType.DOUBLE));
            rooms.get(0).setImage("roomImages/DOUBLE.jpg");
        }
        {
            rooms.add(new Room("Suite 34", 600, 134, RoomType.SINGLE));
            rooms.get(1).setImage("roomImages/SINGLE.jpg");
            rooms.get(1).setSmoking(true);
            rooms.get(1).setDisabled(true);
        }
        {
            rooms.add(new Room("Suite 87", 700, 222, RoomType.SINGLE));
            rooms.get(2).setImage("roomImages/SINGLE.jpg");
        }
        {
            rooms.add(new Room("Suite 127", 550, 227, RoomType.DOUBLEX_2));
            rooms.get(3).setImage("roomImages/DOUBLEX_2.jpg");
        }
        {
            rooms.add(new Room("Penthouse 1", 6000, 358, RoomType.PENTHOUSE));
            rooms.get(4).setImage("roomImages/PENTHOUSE.jpg");
        }

    }*/
}
