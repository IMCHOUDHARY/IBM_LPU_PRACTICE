package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Images;

@Repository
public interface ImagesDAO extends CrudRepository<Images, Integer> {

}
