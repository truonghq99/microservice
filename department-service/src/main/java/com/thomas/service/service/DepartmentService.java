package com.thomas.service.service;

import com.thomas.service.entity.Department;
import com.thomas.service.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){
        log.info("log saveDepartment in departmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId){
        log.info("log findDepartmentById in departmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
