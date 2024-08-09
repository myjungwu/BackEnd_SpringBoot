package com.restapi.emp.repository;

import com.restapi.emp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByDepartmentNameContaining(String departmentName);
}