package com.aakash.training.services;

import com.aakash.training.model.Department;
import com.aakash.training.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartment(long id) {
        return departmentRepository.findById(id).get();
    }

    public void deleteDepartment(long id) {
        departmentRepository.deleteById(id);
    }

    public void updateDepartment(Department department, long id) {
        department.setId(id);
        departmentRepository.save(department);
    }

}
