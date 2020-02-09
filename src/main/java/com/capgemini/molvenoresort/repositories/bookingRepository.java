package com.capgemini.molvenoresort.repositories;

import com.capgemini.molvenoresort.models.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface bookingRepository extends CrudRepository<Booking, Long> {

    //Iterable<Booking>findByBookingByGuestId(Long guestId);
}
