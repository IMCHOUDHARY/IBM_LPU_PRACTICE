package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Images;
import com.example.demo.service.ImagesService;

@RestController
public class ImagesController {

	private ImagesService imagesService;

	@Autowired
	public ImagesController(ImagesService imagesService) {
		super();
		this.imagesService = imagesService;
	}
	
	@GetMapping("/images")
	public List<Images> getAllImages()
	{
		return imagesService.getAllImages();
	}
}
