package com.capgemini.molvenoresort.room;

import com.capgemini.molvenoresort.booking.Booking;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Room {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private int price;
    @Column
    private String name;
    @Column
    private int adult;
    @Column
    private int children;
    @Column
    private boolean disabled;
    @Column
    private boolean smoking;

    @Column
    private String image;


    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @ManyToMany
    private List<Bed> beds;


    //private List<Facilities> facilities;

    //@ManyToMany(mappedBy = "rooms")
    //private List<Booking> bookings;

    public Room(){}

    public Room(String name, int price, long id, RoomType type) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.type = type;
        this.status = RoomStatus.AVAILABLE;
        this.image = "roomImages/SINGLE.jpg";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0)
            return;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

 //   public List<Facilities> getFacilities() {
 //       return facilities;
 //   }

  //  public void setFacilities(List<Facilities> facilities) {
  //      this.facilities = facilities;
   // }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        if (adult > 0)
            this.adult = adult;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        if (children < 0)
            return;
        this.children = children;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /*public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
