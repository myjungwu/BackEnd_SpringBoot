package com.restapi.emp.service.impl;

import com.restapi.emp.entity.Department;
import com.restapi.emp.entity.Employee;
import com.restapi.emp.exception.ResourceNotFoundException;
import com.restapi.emp.repository.DepartmentRepository;
import com.restapi.emp.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;

public class EmpDeptCommon {

    public static Department getDepartment(Long departmentId, DepartmentRepository departmentRepository) {
        String errMsg = String.format("Department is not exists with a given id: %s", departmentId);
        return departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(errMsg, HttpStatus.NOT_FOUND)
                );
    }

    public static Employee getEmployee(Long employeeId, EmployeeRepository employeeRepository) {
        String errMsg = String.format("Employee is not exists with a given id: %s", employeeId);
        return employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(errMsg, HttpStatus.NOT_FOUND));
    }

}
