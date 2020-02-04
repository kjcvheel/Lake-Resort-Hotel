package com.capgemini.molvenoresort.booking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface bookingRepository extends CrudRepository<Booking, Long> {

    Iterable<Booking>findByBookingByGuestId(Long guestId);
}
