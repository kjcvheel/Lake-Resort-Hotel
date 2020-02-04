package com.capgemini.molvenoresort.room;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Bed {
    @Id
    private long id;
    private BedType bedType;

    @ManyToMany
    private List<Room> rooms;

    public Bed(){}
    public Bed(BedType bedType){
        this.bedType = bedType;
    }


    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }
}
