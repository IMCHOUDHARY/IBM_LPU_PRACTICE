package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceBFeignApplication implements CommandLineRunner{
	
	public EmployeeDAO employeeDAO;
	
	@Autowired
	public MicroserviceBFeignApplication(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}



	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBFeignApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		employeeDAO.save(new Employee(1,"ankit","IBM"));
		employeeDAO.save(new Employee(2,"muzu","IBM"));
		employeeDAO.save(new Employee(3,"parag","IBM"));
	}

}
