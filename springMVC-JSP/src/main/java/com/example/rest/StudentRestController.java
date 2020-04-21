package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.exception.StudentNotFoundException;
import com.example.exception.StudentResponseEntity;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define endpoint for "/students" - return list of students
	
	List<Student> theStudents=null;
	@PostConstruct
	public void init()
	{
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
			
		return theStudents;
	}
	
	@PostMapping("/students/add")
	public Student createStudent(@RequestBody Student theStudent)
	{
		theStudents.add(theStudent);
		return theStudent;
		
	}
	
	@GetMapping("/students/{studentID}")
	public Student getStudentById(@PathVariable int studentID) throws StudentNotFoundException {

		
		if ( (studentID >= theStudents.size()) || (studentID < 0) ) {			
			throw new StudentNotFoundException("Student id not found - " + studentID);
		}
		
		return theStudents.get(studentID);
	
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentResponseEntity> handleException(StudentNotFoundException snfe)
	{
	
			/*
			 * StringBuffer br=new StringBuffer(); br.append(HttpStatus.NOT_FOUND);
			 * br.append(snfe.getMessage()); br.append(System.currentTimeMillis()); return
			 * new ResponseEntity<Object>(br,HttpStatus.NOT_FOUND);
			 */
		return new ResponseEntity<StudentResponseEntity>(new StudentResponseEntity(HttpStatus.NOT_FOUND.value(), snfe.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentResponseEntity> handleNumberFormatException(NumberFormatException ipme)
	{
		return new ResponseEntity<StudentResponseEntity>(new StudentResponseEntity(HttpStatus.BAD_REQUEST.value(),"must provide numeric value", System.currentTimeMillis()),HttpStatus.BAD_REQUEST);
	}
}
