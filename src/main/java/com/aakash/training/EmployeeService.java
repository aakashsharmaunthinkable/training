package com.aakash.training;

import com.aakash.training.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee emp) {
        employeeRepository.save(emp);
        return emp;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(long id) {
        return employeeRepository.findById(id).get();
    }

    public Employee deleteEmployee(long id) {
        Employee emp = employeeRepository.findById(id).get();
        employeeRepository.deleteById(id);
        return emp;
    }

    public void updateEmployee(Employee emp, long id) {
        emp.setId(id);
        System.out.println("()()()() -> " + emp.toString());
        employeeRepository.save(emp);
    }

}
