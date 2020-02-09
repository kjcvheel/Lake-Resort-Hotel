package com.capgemini.molvenoresort.repositories;

import com.capgemini.molvenoresort.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
