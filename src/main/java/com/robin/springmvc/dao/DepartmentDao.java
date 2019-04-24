package com.robin.springmvc.dao;

import com.robin.springmvc.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> depatments = null;
    static {
        depatments = new HashMap<>();

        depatments.put(101,new Department(101,"AA"));
        depatments.put(102,new Department(102,"BB"));
        depatments.put(103,new Department(103,"CC"));
        depatments.put(104,new Department(104,"DD"));
    }

    public Collection<Department> getAllDepartments() {
        return depatments.values();
    }

    public Department getDepartmentById(Integer id) {
        return depatments.get(id);
    }
}
