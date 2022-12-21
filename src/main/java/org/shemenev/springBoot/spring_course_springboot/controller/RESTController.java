package org.shemenev.springBoot.spring_course_springboot.controller;

import org.shemenev.springBoot.spring_course_springboot.entity.Employee;
import org.shemenev.springBoot.spring_course_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> ShowAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

//    @GetMapping("/employees/{id}")
//    public Employee getEmployee(@PathVariable int id) throws Exception {
//        Employee employee = employeeService.getEmployee(id);
//
//        if (employee == null) {
//            throw new NoSuchFieldException("There is no employee with ID " + id + " in DataBase");
//        }
//        return employee;
//    }
//
//    @PostMapping("/employees")
//    public Employee addNewEmployee(@RequestBody Employee employee) {
//
//        employeeService.saveEmployee(employee);
//
//        return employee;
//    }
//
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee) {
//
//        employeeService.saveEmployee(employee);
//
//        return employee;
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public String deleteEmployee(@PathVariable int id){
//
//        Employee employee = employeeService.getEmployee(id);
//        if (employee == null){
//            throw new NoSuchEmployeeException("There is no employee with ID" + id + " in database");
//        }
//
//        employeeService.deleteEmployee(id);
//
//        return "employee with ID " +  id + " was deleted";
//    }

}
