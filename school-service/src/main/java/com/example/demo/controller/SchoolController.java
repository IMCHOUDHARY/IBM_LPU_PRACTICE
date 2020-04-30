package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SchoolService;

@RestController
public class SchoolController {
	
	public SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping("/schools/{schoolName}")
	public List<Object> getBySchool(@PathVariable String schoolName)
	{
		return schoolService.getBySchool(schoolName);
	}
}
