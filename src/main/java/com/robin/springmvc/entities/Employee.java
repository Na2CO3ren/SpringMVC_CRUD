package com.robin.springmvc.entities;

public class Employee {
    private Integer id;
    private String lastName;
    private Integer age;
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String lastName, Integer age, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.age = age;
        this.department = department;
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
                '}';
    }
}
