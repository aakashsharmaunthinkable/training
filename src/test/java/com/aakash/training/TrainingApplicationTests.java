package com.aakash.training;

import com.aakash.training.model.Department;
import com.aakash.training.model.Employee;
import com.aakash.training.repository.DepartmentRepository;
import com.aakash.training.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import java.util.List;

@EnableAutoConfiguration
@SpringBootTest
class TrainingApplicationTests {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void testCreateDepartment() {
		Department department = new Department();
		department.setName("TestingABCD");
		departmentRepository.save(department);
		Assertions.assertNotNull(departmentRepository.findById(department.getId()).get());
	}

	@Test
	public void readAllDepartment() {
		List<Department> list = departmentRepository.findAll();
		Assertions.assertTrue(list.size() > 0);
	}

	@Test
	public void testUpdateDepartment() {
		Department department = departmentRepository.findById(1L).get();
		department.setName("DevOps");
		departmentRepository.save(department);
		Assertions.assertEquals(departmentRepository.findById(1L).get().getName(), "DevOps");
	}

	@Test
	public void testSpecificDepartment() {
		Department department = departmentRepository.findById(1L).get();
		Assertions.assertEquals(department.getName(), "Production");
	}

	@Test
	public void testCreateEmployee() {
		Department department = new Department();
		department.setName("TestingABCD");
		department.setId(7L);

		Employee employee = new Employee();
		employee.setDepartment(department);
		employee.setMobile("998800999900");
		employee.setName("Vishal");
		employee.setAddress("Delhi");
		employeeRepository.save(employee);
		Assertions.assertNotNull(employeeRepository.findById(employee.getId()).get());
	}

	@Test
	public void testAllEmployee() {
		List<Employee> list = employeeRepository.findAll();
		Assertions.assertTrue(list.size() > 0);
	}

	@Test
	public void testSpecificEmployee() {
		Employee employee = employeeRepository.findById(2L).get();
		Assertions.assertEquals(employee.getName(), "NOgg");
	}

	@Test
	public void testUpdateEmployee() {
		Employee employee = employeeRepository.findById(3L).get();
		employee.setAddress("Delhi");
		employeeRepository.save(employee);
		Assertions.assertEquals(employeeRepository.findById(3L).get().getAddress(), "Delhi");
	}

}
