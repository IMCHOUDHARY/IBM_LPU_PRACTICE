package com.mycompany.spring_JPA.dao;

import java.util.Collection;

import com.mycompany.spring_JPA.entity.Employee;

public interface EmployeeDAO 
{
	public Employee createEmployee(Employee employee);

	public void removeEmployee(int id);

	public Employee raiseEmployeeSalary(int id, int raise);

	public Employee findEmployee(int id);

	public Collection<Employee> findAllEmployees();
}
