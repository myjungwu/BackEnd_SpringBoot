package com.restapi.emp.service.impl;

import com.restapi.emp.dto.DepartmentDto;
import com.restapi.emp.dto.mapper.DepartmentMapper;
import com.restapi.emp.entity.Department;
import com.restapi.emp.exception.ResourceNotFoundException;
import com.restapi.emp.repository.DepartmentRepository;
import com.restapi.emp.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    //Constructor Injection
//    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Transactional(readOnly = true)
    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
//        Optional<Department> optional = departmentRepository.findById(departmentId);
//        Department department = optional.orElseThrow(
//                () -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId) );

        Department department = EmpDeptCommon.getDepartment(departmentId, departmentRepository);
        return DepartmentMapper.mapToDepartmentDto(department);
    }
    
// EmpDeptCommon 클래스의 getDepartment() 메서드로 대체됨
//    private Department getDepartment(Long departmentId) {
//        String errMsg = String.format("Department is not exists with a given id: %s", departmentId);
//        return departmentRepository.findById(departmentId)
//                .orElseThrow(() ->
//                        new ResourceNotFoundException(errMsg, HttpStatus.NOT_FOUND)
//        );
//    }

    @Transactional(readOnly = true)
    @Override
    public List<DepartmentDto> getAllDepartments() {
        // List<Department> ==> List<DepartmentDto>
        List<Department> departments = departmentRepository.findAll();
        return departments
                .stream()
                .map(DepartmentMapper::mapToDepartmentDto)
                .toList(); //Stream<DepartmentDto> => List<DepartmentDto>
                //.map((department) -> DepartmentMapper.mapToDepartmentDto(department))
                //.collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department = EmpDeptCommon.getDepartment(departmentId, departmentRepository);
        //Dirty Check - setter method 호출
        if (updatedDepartment.getDepartmentName() != null)
            department.setDepartmentName(updatedDepartment.getDepartmentName());
        if (updatedDepartment.getDepartmentDescription() != null)
            department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());

        //Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = EmpDeptCommon.getDepartment(departmentId, departmentRepository);

        departmentRepository.delete(department);
    }
}