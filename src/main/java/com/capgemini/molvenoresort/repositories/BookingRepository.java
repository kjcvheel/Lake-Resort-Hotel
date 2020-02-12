package com.capgemini.molvenoresort.repositories;

import com.capgemini.molvenoresort.models.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findByStartDateLessThanAndEndDateGreaterThan(LocalDate endDate, LocalDate startDate);
}
