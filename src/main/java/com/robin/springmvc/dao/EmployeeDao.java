package com.robin.springmvc.dao;

import com.robin.springmvc.entities.Department;
import com.robin.springmvc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentDao;

    private static Map<Integer, Employee> employees = null;
    private static Integer initID = 2106;
    static {
        employees = new HashMap<>();

        employees.put(2101,new Employee(2101,"robin",18,new Department(101,"AA")));
        employees.put(2102,new Employee(2102,"jinglan",18,new Department(101,"AA")));
        employees.put(2103,new Employee(2103,"hanlu",18,new Department(102,"BB")));
        employees.put(2104,new Employee(2104,"zhiyong",18,new Department(102,"BB")));
        employees.put(2105,new Employee(2105,"lanping",18,new Department(103,"CC")));
    }

    public Collection<Employee> getAllEmployees() {
        return employees.values();
        //return new LinkedList<>();
    }

    public void addEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initID++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public void deleteEmployee(Integer id) {
        employees.remove(id);
    }
}
