package com.ramlearning.springsecurity.basicauth.controller;

import com.ramlearning.springsecurity.basicauth.entity.Employee;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    List<Employee> empList = Arrays.asList(new Employee(1, "Ram"),
            new Employee(2, "Kiran"));

    @GetMapping()
    public List<Employee> getEmployees() {
        return empList;
    }

    @GetMapping("/csrf")
    public CsrfToken getCSRFToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        empList.add(employee);
        return employee;
    }
}
