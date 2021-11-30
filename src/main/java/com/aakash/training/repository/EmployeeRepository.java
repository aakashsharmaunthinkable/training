package com.aakash.training.repository;

import com.aakash.training.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query("from Employee where department_id = 17")
    List<Employee> findByDepartment_Id(long id);

    @Query(value = "SELECT * from emp where name like %:name%", nativeQuery = true)
    List<Employee> findEmployeeByName(String name);

    @Query(value = "SELECT * from emp where address like %:address%", nativeQuery = true)
    List<Employee> findEmployeeByAddress(String address);

}
