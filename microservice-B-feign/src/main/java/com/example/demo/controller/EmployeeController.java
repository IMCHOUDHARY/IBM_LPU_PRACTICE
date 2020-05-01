package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
    @Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/employees/hi/{name}")
	public String hi(@PathVariable String name)
	{
		return "hi"+name;
	}
	
	@GetMapping("/employees/{departmentName}")
	public List<Employee> findEmployeeByDepartment(@PathVariable String departmentName)
	{
		return employeeService.findEmployeeByDepartment(departmentName);
	}
	
	@PostMapping("/employees/add")
	public void addEmployee(@RequestBody Employee employee)
	{
		System.out.println("ADD EMPLOYEE!!!!");
		employeeService.addEmployee(employee);
		System.out.println("ADD EMPLOYEE222222!!!!");
	}
}
