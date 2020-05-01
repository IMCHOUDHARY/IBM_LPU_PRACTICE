package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.EmployeeClient;
import com.example.demo.model.Employee;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class DepartmentController {
	
	private EmployeeClient employeeClient;
	@Autowired
	public DepartmentController(EmployeeClient employeeClient) {
	
		this.employeeClient = employeeClient;
	}

	@GetMapping("/departments/{departmentName}")
	public ResponseEntity<List<Object>> findEmployee(@PathVariable String departmentName)
	{
		//String result=employeeClient.findEmployee(departmentName);
		//return ResponseEntity.status(HttpStatus.OK).body(result);
		return new ResponseEntity<List<Object>>(employeeClient.findEmployee(departmentName), HttpStatus.OK);
	}

	@PostMapping("/departments/addEmployee")
	public void addEmployee(@RequestBody Employee employee)
	{
		employeeClient.addEmployee(employee);
	}
}
