package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ImagesDAO;
import com.example.demo.entity.Images;

@Service
public class ImagesServiceImpl implements ImagesService{
	
	private ImagesDAO imagesDAO;

	@Autowired
	public ImagesServiceImpl(ImagesDAO imagesDAO) {
		super();
		this.imagesDAO = imagesDAO;
	}


	@Override
	public List<Images> getAllImages() {
		// TODO Auto-generated method stub
		return (List<Images>) imagesDAO.findAll();
	}

}
