package com.capgemini.molvenoresort.models;

import com.capgemini.molvenoresort.enums.BookingStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "userID")
    private Guest mainBooker;
    @Column
    private long invoiceID;
    @ManyToMany
    private List<Room> rooms;
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;
    @Column
    private int adults;
    @Column
    private int children;
    @Column
    private boolean paymentStatus;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    public Booking(){
        this.status = BookingStatus.RESERVED;
    }

    public Booking(long id, Guest mainBooker, LocalDate startDate, LocalDate endDate){
        this.id = id;
        this.mainBooker = mainBooker;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = BookingStatus.RESERVED;
    }

    public long getId() { return id; }

    public void setId(long id) {
        if(id > 0)
            this.id = id;
    }

    public Guest getMainBooker() {return mainBooker;}

    public void setMainBooker(Guest temp) {
        this.mainBooker = temp;     
    }
    public long getInvoiceID() {return invoiceID;}

    public void setInvoiceID(int invoiceID) {
        if(invoiceID > 0)
            this.invoiceID = invoiceID;
    }

    public List<Room> getRoomNumbers() {return rooms;}

    public void setRoomNumbers(List<Room> roomNumbers) {this.rooms = roomNumbers;}

    public LocalDate getStartDate() {return startDate;}

    public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
    }

    public LocalDate getEndDate() {return endDate;}

    public void setEndDate(LocalDate endDate) {
        if(endDate.isAfter(this.startDate))
            this.endDate = endDate;
    }

    public int getGuests() {return adults+children;}

    public void setGuests(int adults, int children){
        if (adults > 0)
            this.adults = adults;
        if (children > 0)
            this.children = children;
    }

    public int getAdults() {return adults;}

    public void setAdults(int adults) {
        if (adults > 0)
            this.adults = adults;
    }

    public int getChildren() {return children;}

    public void setChildren(int children) {
        if (children > 0)
            this.children = children;
    }

    public boolean isPaymentStatus() {return paymentStatus;}

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
        if(this.paymentStatus)
            setStatus(BookingStatus.BOOKED);
    }

    public BookingStatus getStatus() {return status;}

    public void setStatus(BookingStatus status) {this.status = status;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
