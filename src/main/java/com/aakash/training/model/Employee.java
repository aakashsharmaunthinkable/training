package com.aakash.training.model;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "emp", schema = "emp")
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    @Size(max = 20, message = "Name longer than acceptable value")
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "mobile", nullable = false)
    @Pattern(regexp = "(^$|[0-9]){10}", message = "Phone number longer than expected")
    private String mobile;

    public Department getDepartment() {
        return department;
    }

    public Employee(long id, String name, String address, String mobile, Department department) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.department = department;
    }

    @ManyToOne(optional = false)
    private Department department;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public Employee() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Employee(String name, String address, String mobile) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public Employee(long id, String name, String address, String mobile) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", department=" + department.getName() +
                '}';
    }
}
