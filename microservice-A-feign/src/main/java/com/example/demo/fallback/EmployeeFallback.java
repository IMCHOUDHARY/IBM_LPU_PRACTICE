package com.example.demo.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.client.EmployeeClient;
import com.example.demo.model.Employee;

@Component
public class EmployeeFallback implements EmployeeClient {

	@Override
	public String callHi(String name) {
		// TODO Auto-generated method stub
		return "<p>We Will Be Resuming Shortly!!!!!!<p>";
	}

	@Override
	public List<Object> findEmployee(String departmentName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
