package com.robin.springmvc.handler;

import com.robin.springmvc.dao.DepartmentDao;
import com.robin.springmvc.dao.EmployeeDao;
import com.robin.springmvc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/robin")
public class CRUDHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @ModelAttribute
    public void setEmployee(@RequestParam(value = "id",required = false) Integer id, Map<String, Object> map) {
        System.out.println("model attribute");
        if (id != null) {
            map.put("employee",employeeDao.getEmployeeById(id));
        }
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        System.out.println("add employee : " + employee.toString());
        employeeDao.addEmployee(employee);
        return "redirect:/robin/showAllEmployees";
    }


    @RequestMapping("/showInput")
    public String showInput(Map<String,Object> map) {
        System.out.println("show input");

        map.put("employee",new Employee());
        map.put("departments",departmentDao.getAllDepartments());
        return "input";
    }

    @RequestMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable("id") Integer id, Map<String, Object> map) {
        System.out.println("edit employee: id = " + id);
        map.put("employee",employeeDao.getEmployeeById(id));
        map.put("departments",departmentDao.getAllDepartments());
        return "input";
    }

    @RequestMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        System.out.println("delete employee: " + id);
        employeeDao.deleteEmployee(id);
        return "redirect:/robin/showAllEmployees";
    }

    @RequestMapping("/showAllEmployees")
    public String showAllEmployees(Map<String, Object> map) {
        System.out.println("show all employees");

        map.put("employees", employeeDao.getAllEmployees());
        return "list";
    }

    @RequestMapping("/testConnection")
    public String testConnection() {
        System.out.println("connection success");
        return "list";
    }
}