package com.capgemini.molvenoresort.repositories;

import com.capgemini.molvenoresort.models.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findByStartDateLessThan(LocalDate startDate);

    List<Booking> findByStartDateLessThanEqualAndEndDateGreaterThan(LocalDate startDate, LocalDate date);
//    List<Booking> findByStartDateLessThanEqual(LocalDate startDate);

    List<Booking> findByStartDateLessThanEqualAndEndDateGreaterThanOrEndDateGreaterThanEqualAndStartDateLessThan(LocalDate startDate, LocalDate date,LocalDate endDate, LocalDate date2);

//    List<Booking> findByEndDateBetweenOrStartDateBetween(LocalDate date1, LocalDate date2, LocalDate date3, LocalDate date4);

    List<Booking> findByStartDateLessThanAndEndDateGreaterThan(LocalDate endDate, LocalDate startDate);
}
