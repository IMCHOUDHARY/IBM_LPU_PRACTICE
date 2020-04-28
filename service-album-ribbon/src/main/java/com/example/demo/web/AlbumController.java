package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AlbumService;

@RestController
public class AlbumController {
	
	@Autowired
	public AlbumService albumService;
	
	@GetMapping("/albums")
	public List<Object> getImages()
	{
		return albumService.getImages();
	}
}
