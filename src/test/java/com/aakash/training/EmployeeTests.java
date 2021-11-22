package com.aakash.training;

import com.aakash.training.model.Department;
import com.aakash.training.model.Employee;
import com.aakash.training.repository.DepartmentRepository;
import com.aakash.training.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@EnableAutoConfiguration
@SpringBootTest
public class EmployeeTests {

    private static long testEmployeeId;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    @Order(1)
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setDepartment(departmentRepository.findById(1L).get());
        employee.setMobile("9473945034");
        employee.setName("Vishal");
        employee.setAddress("Mumbai");
        employeeRepository.save(employee);
        testEmployeeId = employee.getId();
        Assertions.assertNotNull(employeeRepository.findById(employee.getId()).get());
    }

    @Test
    @Order(2)
    public void testAllEmployee() {
        List<Employee> list = employeeRepository.findAll();
        Assertions.assertTrue(list.size() > 0);
    }

    @Test
    @Order(3)
    public void testSpecificEmployee() {
        Employee employee = employeeRepository.findById(testEmployeeId).get();
        Assertions.assertEquals("Vishal", employee.getName());
    }

    @Test
    @Order(4)
    public void testUpdateEmployee() {
        Employee employee = employeeRepository.findById(testEmployeeId).get();
        employee.setAddress("Delhi");
        employeeRepository.save(employee);
        Assertions.assertEquals("Delhi", employeeRepository.findById(testEmployeeId).get().getAddress());
    }

    @Test
    @Order(5)
    public void testDeleteEmployee() {
        employeeRepository.deleteById(testEmployeeId);
        Assertions.assertFalse(employeeRepository.existsById(testEmployeeId));
    }

}
