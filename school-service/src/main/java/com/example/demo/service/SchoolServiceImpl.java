package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Service
@EnableTransactionManagement
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getBySchool(String schoolName) {
		// TODO Auto-generated method stub
		List<Object> lis = restTemplate.getForObject("http://localhost:9696/students/"+schoolName, List.class);
		return lis;
	}

}
