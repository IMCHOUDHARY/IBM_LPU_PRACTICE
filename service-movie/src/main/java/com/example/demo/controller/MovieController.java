package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Movie;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.UserResponseEntity;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {
	
	public MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	@GetMapping("/movies/{id}")
	public List<Movie> getAllMovies(@PathVariable int id) throws UserNotFoundException
	{
		List<Movie> mov = movieService.getAllMovies(id);
		if(mov==null)
			throw new UserNotFoundException("User Is Not Authorized");
		return mov;
	}
	
	@ExceptionHandler
	public ResponseEntity<UserResponseEntity> handleException(UserNotFoundException snfe)
	{
		return new ResponseEntity<UserResponseEntity>(new UserResponseEntity(HttpStatus.NOT_FOUND.value(), snfe.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
}
