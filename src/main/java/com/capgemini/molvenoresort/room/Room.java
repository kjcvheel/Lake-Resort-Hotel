package com.capgemini.molvenoresort.room;

import java.util.List;

public class Room {
    private String id;
    private int price;
    private int number;
    private RoomType type;
    private List<Bed> beds;
    private List<Facilities> facilities;
    private int adult;
    private int children;
    private boolean disabled;
    private boolean smoking;
    private RoomStatus status;

    public Room(){}

    public Room(String id, int price, int number, RoomType type) {
        this.id = id;
        this.price = price;
        this.number = number;
        this.type = type;
        this.status = RoomStatus.AVAILABLE;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0)
            return;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number > 0)
            this.number = number;
    }

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

    public List<Facilities> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facilities> facilities) {
        this.facilities = facilities;
    }

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
}
