package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.InstructorDAO;
import com.example.demo.data.Instructor;
import com.example.demo.data.InstructorDetail;


@SpringBootApplication
public class SpringBootJpaInstructorApplication implements CommandLineRunner{
	
	private InstructorDAO instructorDAO;
	
	@Autowired
	public SpringBootJpaInstructorApplication(InstructorDAO instructorDAO) {
		super();
		this.instructorDAO = instructorDAO;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaInstructorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Instructor i = new Instructor("ankit","choudhary","abc@gmail.com");
		i.setInstructorDetail(new InstructorDetail("gggg","adsd"));
		
		instructorDAO.createInstructor(i);
	}

}
