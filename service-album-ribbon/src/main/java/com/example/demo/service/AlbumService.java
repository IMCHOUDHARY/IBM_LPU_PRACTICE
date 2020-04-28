package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumService {

	@Autowired
	RestTemplate restTemplate;
	
	public List<Object> getImages() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://SERVICE-IMAGES/images", List.class);
	}

}
