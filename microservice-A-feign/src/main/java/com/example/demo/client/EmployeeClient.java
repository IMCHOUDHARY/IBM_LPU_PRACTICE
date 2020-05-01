package com.example.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.fallback.EmployeeFallback;
import com.example.demo.model.Employee;

@FeignClient(value="service-B", fallback = EmployeeFallback.class)
public interface EmployeeClient {

	@GetMapping("/api/employees/hi/{name}")
	public String callHi(@PathVariable String name);

	@GetMapping("/api/employees/{departmentName}")
	public List<Object> findEmployee(@PathVariable String departmentName);
	
	@PostMapping("/api/employees/add")
	public void addEmployee(@RequestBody Employee employee);
}
