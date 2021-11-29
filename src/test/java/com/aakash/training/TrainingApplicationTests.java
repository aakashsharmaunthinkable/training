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

}
