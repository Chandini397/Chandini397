package com.example.springbooth2.controller;

import com.example.springbooth2.dao.EmployeeRepository;
import com.example.springbooth2.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
        repository.save(employee);
        return "Employee saved...";
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAll(){
        return repository.findAll();
    }

    @GetMapping("/getEmployeeByDept/{dept}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String dept){
        return repository.findByDept(dept);
    }
}
