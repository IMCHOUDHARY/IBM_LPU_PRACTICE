package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	public EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployee()
	{
		return employeeService.findAllEmployee();
	}
	
	@PostMapping("/add_employee")
	public void addEmployee(Employee employee)
	{
		employeeService.addEmployee(employee);
		findAllEmployee();
	}
}
