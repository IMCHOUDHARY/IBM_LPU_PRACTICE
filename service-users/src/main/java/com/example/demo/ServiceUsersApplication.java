package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.UsersDAO;
import com.example.demo.entity.Users;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceUsersApplication implements CommandLineRunner{

	public UsersDAO usersDAO;
	
	@Autowired
	public ServiceUsersApplication(UsersDAO usersDAO) {
		super();
		this.usersDAO = usersDAO;
	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceUsersApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		usersDAO.save(new Users(1,"ankit","best"));
		usersDAO.save(new Users(2,"prince","best"));
		usersDAO.save(new Users(3,"honey","best"));
	}

}
