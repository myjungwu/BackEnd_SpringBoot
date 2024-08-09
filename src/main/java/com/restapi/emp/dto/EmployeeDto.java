package com.restapi.emp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;

    private DepartmentDto departmentDto;

    public EmployeeDto(Long id,String firstName,String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public EmployeeDto(Long id,String firstName,String lastName, String email, Long departmentId) {
        this(id,firstName,lastName,email);
        this.departmentId = departmentId;
    }


    public EmployeeDto(Long id,String firstName,String lastName, String email, DepartmentDto departmentDto) {
        this(id,firstName,lastName,email);
        this.departmentDto = departmentDto;
    }
}