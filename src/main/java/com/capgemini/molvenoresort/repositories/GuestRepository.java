package com.capgemini.molvenoresort.repositories;

import com.capgemini.molvenoresort.models.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
