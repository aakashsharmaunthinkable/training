package com.aakash.training;

import com.aakash.training.model.Department;
import com.aakash.training.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@EnableAutoConfiguration
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentTests {

    private static long testDepartmentId= 0;

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    @Order(1)
    public void testCreateDepartment() {
        Department department = new Department();
        department.setName("TestingDept");
        departmentRepository.save(department);
        testDepartmentId = department.getId();
        System.out.println("()()()() TEST_CREATE_DEPARTMENT => " + department.getId());
        System.out.println("()()()() global => " + testDepartmentId);
        Assertions.assertNotNull(departmentRepository.findById(department.getId()).get());
    }

    @Test
    @Order(2)
    public void readAllDepartment() {
        List<Department> list = departmentRepository.findAll();
        Assertions.assertTrue(list.size() > 0);
    }

    @Test
    @Order(3)
    public void testSpecificDepartment() {
        Department department = departmentRepository.findById(testDepartmentId).get();
        Assertions.assertEquals("TestingDept", department.getName());
    }

    @Test
    @Order(4)
    public void testUpdateDepartment() {
        Department department = departmentRepository.findById(testDepartmentId).get();
        department.setName("DevOps");
        departmentRepository.save(department);
        Assertions.assertEquals(departmentRepository.findById(testDepartmentId).get().getName(), "DevOps");
    }

    @Test
    @Order(5)
    public void testDeleteDepartment() {
        departmentRepository.deleteById(testDepartmentId);
        Assertions.assertFalse(departmentRepository.existsById(testDepartmentId));
    }

}
