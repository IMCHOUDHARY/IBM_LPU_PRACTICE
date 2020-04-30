package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;

@Service
@EnableTransactionManagement
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}


	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeDAO.findAll();
	}


	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.save(employee);
	}

}
