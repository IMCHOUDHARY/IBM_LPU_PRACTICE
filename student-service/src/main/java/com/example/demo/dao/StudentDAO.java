package com.example.demo.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentDAO extends CrudRepository<Student, Integer> {

	@Query
	public Iterable<Student> findBySchoolName(String schoolName);
}
