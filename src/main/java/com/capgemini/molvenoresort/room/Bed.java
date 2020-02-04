package com.capgemini.molvenoresort.room;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Bed {
    private BedType bedType;

    @ManyToMany
    private List<Room> rooms;



    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }
}
