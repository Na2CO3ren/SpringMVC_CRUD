package com.robin.springmvc.converter;

import com.robin.springmvc.dao.DepartmentDao;
import com.robin.springmvc.entities.Department;
import com.robin.springmvc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter implements Converter<String, Employee> {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Employee convert(String source) {
        Employee employee = new Employee();

        if (source != null) {
            String str[] = source.split("-");

            if (str.length == 3) {
                employee.setId(null);
                employee.setLastName(str[0]);
                employee.setAge(Integer.parseInt(str[1]));
                employee.setDepartment(departmentDao.getDepartmentById(Integer.parseInt(str[2])));
            }
        }

        return employee;
    }
}
