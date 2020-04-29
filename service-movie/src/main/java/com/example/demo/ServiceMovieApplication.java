package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.MovieDAO;
import com.example.demo.entity.Movie;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceMovieApplication implements CommandLineRunner{

	public MovieDAO movieDAO;
	
	@Autowired
	public ServiceMovieApplication(MovieDAO movieDAO) {
		super();
		this.movieDAO = movieDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceMovieApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		movieDAO.save(new Movie(1,"abc"));
		movieDAO.save(new Movie(2,"xyz"));
	}
}
