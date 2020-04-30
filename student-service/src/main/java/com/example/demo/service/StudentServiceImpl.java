package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDAO;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	public StudentDAO studentDAO;
	
	@Autowired
	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}


	@SuppressWarnings("null")
	@Override
	public List<Student> getBySchool(String schoolName) {
		// TODO Auto-generated method stub
		//return (List<Student>) studentDAO.findAll();
		List<Student> lis = new ArrayList<Student>();
		Iterable<Student> itr = studentDAO.findBySchoolName(schoolName);
		for(Student s:itr)
		{
			lis.add(s);
		}
		return lis;
	}

}
