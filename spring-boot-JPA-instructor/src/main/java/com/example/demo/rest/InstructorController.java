package com.example.demo.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.InstructorDAO;
import com.example.demo.data.Instructor;
import com.example.demo.data.InstructorDetail;


@RestController
@RequestMapping("/api")
public class InstructorController {

	private InstructorDAO instructorDAO;

	@Autowired
	public InstructorController(InstructorDAO instructorDAO) {
		super();
		this.instructorDAO = instructorDAO;
	}
	
	@GetMapping("/instructor/test")
	public String test()
	{
		return "working fine!!!!!";
	}
	
	@PostMapping("/instructor/add")
	public void createInstructor(@Valid @RequestBody Instructor inst)
	{
		instructorDAO.createInstructor(inst);
	}
	
	@PostMapping("/instructor_detail/add")
	public void createInstructorDetail(@Valid @RequestBody InstructorDetail inst)
	{
		instructorDAO.createInstructorDetail(inst);
	}
	
	@GetMapping("/instructor/{id}")
	public Instructor getInstructor(@PathVariable int id)
	{
		return instructorDAO.getInstructor(id);
	}
	
	@GetMapping("/instructor_detail/{id}")
	public InstructorDetail getInstructorDetail(@PathVariable int id)
	{
		return instructorDAO.getInstructorDetail(id);
	}
	
	@DeleteMapping("/instructor/delete/{id}")
	public void deleteInstructor(@PathVariable int id)
	{
		instructorDAO.deleteInstructor(id);
	}
	
	@PutMapping("/instructor/update/{id}")
	public Instructor updateInstructor(@RequestBody Instructor inst, @PathVariable int id)
	{
		return instructorDAO.updateInstructor(inst,id);
	}
}

/*{
	"firstName":"ankit",
	"lastName":"choudhary",
	"email":"abc@gmail.com",
	"instructorDetail":{
		"youtubeChannel":"hello",
		"hobby":"pubg"
	}
}*/

/*{
	"youtubeChannel":"hello",
	"hobby":"pubg",
	"instructor":{
		"firstName":"sdsa",
		"lastName":"choudhary",
		"email":"abc@gmail.com"
	}
}*/
