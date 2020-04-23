package com.example.demo.dao;

import java.util.List;

import com.example.demo.data.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	
	public Employee createEmployee(Employee employee);

	public Employee findById(int employeeId);

	public Employee deleteEmployee(int employeeId);

}
