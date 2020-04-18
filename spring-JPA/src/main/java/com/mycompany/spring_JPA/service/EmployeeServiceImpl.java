package com.mycompany.spring_JPA.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.spring_JPA.dao.EmployeeDAO;
import com.mycompany.spring_JPA.entity.Employee;

@Service("service")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;
	

	public Employee createEmployee(Employee employee) {
		return dao.createEmployee(employee);
	}


	public void removeEmployee(int id) {
		// TODO Auto-generated method stub
		dao.removeEmployee(id);
	}


	public Employee raiseEmployeeSalary(int id, int raise) {
		// TODO Auto-generated method stub
		return dao.raiseEmployeeSalary(id, raise);
	}


	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.findEmployee(id);
	}


	public Collection<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return dao.findAllEmployees();
	}



}
