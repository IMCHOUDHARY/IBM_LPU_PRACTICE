package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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

	@Override
	public List<Employee> findEmployeeByDepartment(String departmentName) {
		// TODO Auto-generated method stub
		List<Employee> lis = new ArrayList<Employee>();
		Iterable<Employee> i = employeeDAO.findByDepartmentName(departmentName);
		for(Employee e:i)
		{
			lis.add(e);
		}
		return lis;
	}

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.save(employee);
	}

}
