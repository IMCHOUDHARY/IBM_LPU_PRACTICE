package com.example.demo.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.data.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
public class EmployeeController {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeController(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	
	
	
	@ApiOperation(value = "View a list of available employees", response = List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	@GetMapping("/employees")
	public List<Employee> listEmployee()
	{
		return employeeDAO.getEmployees();
	}
	
	
	
	@ApiOperation(value = "Add an employee")
	@PostMapping("/employees/add")
	public Employee createEmployee(
			@ApiParam(value = "Employee object store in database table", required = true)
			@Valid @RequestBody Employee employee) {
		return employeeDAO.createEmployee(employee);
	}
	
	
	@ApiOperation(value = "Get an employee by Id")
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(
			@ApiParam(value = "Employee id from which employee object will retrieve", required = true)
			@PathVariable(value = "id") int employeeId)
	{
			Employee employee = employeeDAO.findById(employeeId);
			return employee;
	}
	
	
	@ApiOperation(value = "Delete an employee by Id")
	@DeleteMapping("/employees/delete/{id}")
	public Employee deleteEmployee(
			@ApiParam(value = "Employee id from which employee object will retrieve", required = true)
			@PathVariable(value = "id") int employeeId)
	{
			Employee employee = employeeDAO.deleteEmployee(employeeId);
			return employee;
	}


}
