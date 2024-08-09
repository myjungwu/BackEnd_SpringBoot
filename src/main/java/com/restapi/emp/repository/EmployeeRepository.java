package com.restapi.emp.repository;

import com.restapi.emp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Query method, Finder method
    Optional<Employee> findByEmail(String email);
    List<Employee> findByFirstNameContains(String firstName);
}