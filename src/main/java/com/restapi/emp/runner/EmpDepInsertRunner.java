package com.restapi.emp.runner;

import com.restapi.emp.entity.Department;
import com.restapi.emp.entity.Employee;
import com.restapi.emp.repository.DepartmentRepository;
import com.restapi.emp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("prod")  //InsertRunner 가 동작하지 않도록 하려면 현재 Profile과 다른 값을 주면 됨
@RequiredArgsConstructor
public class EmpDepInsertRunner implements ApplicationRunner {
    final DepartmentRepository departmentRepository;
    final EmployeeRepository employeeRepository;

    //Constructor Injection ( 생성자 주입 )
//    public EmpDepInsertRunner(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
//        this.departmentRepository = departmentRepository;
//        this.employeeRepository = employeeRepository;
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Department department1 = new Department();
        department1.setDepartmentName("HR");
        department1.setDepartmentDescription("performs human resource management functions");

        Department department2 = new Department();
        department2.setDepartmentName("Marketing");
        department2.setDepartmentDescription("creates strategies for selling its company's products");

        Department department3 = new Department();
        department3.setDepartmentName("Sales");
        department3.setDepartmentDescription("identifies sales goals and objectives and prepares a sales plan");

        departmentRepository.saveAll(List.of(department1, department2, department3));

        Employee employee1 = new Employee();
        employee1.setFirstName("John");
        employee1.setLastName("Smith");
        employee1.setEmail("John@company.com");
        employee1.setDepartment(department1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Sarah");
        employee2.setLastName("Johnson");
        employee2.setEmail("Sarah@company.com");
        employee2.setDepartment(department2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Emily");
        employee3.setLastName("Brown");
        employee3.setEmail("Emilyh@company.com");
        employee3.setDepartment(department3);

        employeeRepository.saveAll(List.of(employee1,employee2,employee3));
    }
}
