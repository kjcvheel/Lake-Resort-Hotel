package com.capgemini.molvenoresort.booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Booking {
    private int id;
    private int guestID;
    private int invoiceID;
    private List<Integer> roomNumbers;
    private LocalDate startDate;
    private LocalDate endDate;
    private int adults;
    private int children;
    private boolean paymentStatus;
    private BookingStatus status;

    public Booking(){
        this.status = BookingStatus.RESERVED;
    }

    public Booking(int id, int guestID, LocalDate startDate, LocalDate endDate){
        this.id = id;
        this.guestID = guestID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = BookingStatus.RESERVED;
    }

    public int getId() { return id; }

    public void setId(int id) {
        if(id > 0)
            this.id = id;
    }

    public int getGuestID() {return guestID;}

    public void setGuestID(int guestID) {
        if(guestID >0)
            this.guestID = guestID;
    }

    public int getInvoiceID() {return invoiceID;}

    public void setInvoiceID(int invoiceID) {
        if(invoiceID > 0)
            this.invoiceID = invoiceID;
    }

    public List<Integer> getRoomNumbers() {return roomNumbers;}

    public void setRoomNumbers(List<Integer> roomNumbers) {this.roomNumbers = roomNumbers;}

    public LocalDate getStartDate() {return startDate;}

    public void setStartDate(LocalDate startDate) {
        if(startDate.isAfter(LocalDate.now()) || startDate.isEqual(LocalDate.now()))
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
