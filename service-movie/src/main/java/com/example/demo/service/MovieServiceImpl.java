package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.MovieDAO;
import com.example.demo.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	public MovieDAO movieDAO;
	
	@Autowired
	public MovieServiceImpl(MovieDAO movieDAO) {
		super();
		this.movieDAO = movieDAO;
	}

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Movie> getAllMovies(int id) {
		Object obj = restTemplate.getForObject("http://localhost:1000/users/"+id, Object.class);
		if(obj!=null)
		{
			return (List<Movie>) movieDAO.findAll();
		}
		return null;
	}

}
