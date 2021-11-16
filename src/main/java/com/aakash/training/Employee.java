package com.aakash.training;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name = "emp", schema = "emp")
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "mobile", nullable = false)
    private String mobile;

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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
