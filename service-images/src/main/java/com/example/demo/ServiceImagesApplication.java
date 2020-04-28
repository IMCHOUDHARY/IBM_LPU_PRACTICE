package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.ImagesDAO;
import com.example.demo.entity.Images;
import com.example.demo.service.ImagesService;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceImagesApplication implements CommandLineRunner{
	private ImagesDAO imagesDAO;
	
	@Autowired
	public ServiceImagesApplication(ImagesDAO imagesDAO) {
		super();
		this.imagesDAO = imagesDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceImagesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stu
		imagesDAO.save(new Images(1,"abc","xyz"));
		imagesDAO.save(new Images(2,"sas","pqr"));
	}

}
