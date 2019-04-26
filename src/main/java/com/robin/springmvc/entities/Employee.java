package com.robin.springmvc.entities;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;

public class Employee {
    private Integer id;
    @NotEmpty
    private String lastName;
    private Integer age;
    private Department department;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @NumberFormat(pattern = "##,###.#")
    private Float salary;

    public Employee() {
    }

    public Employee(Integer id, String lastName, Integer age, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.age = age;
        this.department = department;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date bith) {
        this.birth = bith;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", birth=" + birth +
                ", salary=" + salary +
                '}';
    }
}
