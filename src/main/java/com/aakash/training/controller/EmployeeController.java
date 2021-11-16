package com.aakash.training.controller;

import com.aakash.training.model.Employee;
import com.aakash.training.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployee();
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public Employee deleteEmployee(@PathVariable long id) {
        return employeeService.deleteEmployee(id);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
        employeeService.updateEmployee(employee, id);
    }

}
