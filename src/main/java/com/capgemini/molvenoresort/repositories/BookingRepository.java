package com.capgemini.molvenoresort.repositories;

import com.capgemini.molvenoresort.models.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

}
