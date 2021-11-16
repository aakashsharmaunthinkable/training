package com.aakash.training.controller;

import com.aakash.training.model.Department;
import com.aakash.training.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public List<Department> getDepartments() {
        return departmentService.getAllDepartments();
    }

    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.GET)
    public Department getDepartment(@PathVariable long id) {
        return departmentService.getDepartment(id);
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.DELETE)
    public void  deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartment(id);
    }

    @RequestMapping(value = "/departments/{id}", method = RequestMethod.PUT)
    public void updateDepartment(@RequestBody Department department, @PathVariable long id) {
        departmentService.updateDepartment(department, id);
    }

}
