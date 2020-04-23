package com.example.demo.dao;

import com.example.demo.data.Instructor;
import com.example.demo.data.InstructorDetail;

public interface InstructorDAO 
{
	public void createInstructor(Instructor inst);
	
	public void createInstructorDetail(InstructorDetail inst);

	public Instructor getInstructor(int id);

	InstructorDetail getInstructorDetail(int id);

	public void deleteInstructor(int id);

	public Instructor updateInstructor(Instructor inst, int id);
}
