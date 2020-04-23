package com.example.demo.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.Instructor;
import com.example.demo.data.InstructorDetail;

@Repository("instructorDAO")
@EnableTransactionManagement
public class InstructorDAOImpl implements InstructorDAO {

	private EntityManager entityManager;

	@Autowired
	public InstructorDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	
	@Override
	@Transactional
	public void createInstructor(Instructor inst)
	{
		Session session=entityManager.unwrap(Session.class);
		session.save(inst);
	}


	@Override
	@Transactional
	public void createInstructorDetail(InstructorDetail inst) {
		Session session=entityManager.unwrap(Session.class);
		Instructor i = inst.getInstructor();
		i.setInstructorDetail(inst);
		session.save(i);
	}


	@Override
	public Instructor getInstructor(int id) {
		//Session session=entityManager.unwrap(Session.class);
		Instructor i = entityManager.find(Instructor.class, id);
		//Instructor i = session.get(Instructor.class, id);
		//System.out.println(i);
		return i;
	}
	
	@Override
	public InstructorDetail getInstructorDetail(int id) {
		InstructorDetail i = entityManager.find(InstructorDetail.class, id);
		//Instructor i = session.get(Instructor.class, id);
		//System.out.println(i);
		return i;
	}


	@Override
	@Transactional
	public void deleteInstructor(int id) {
		entityManager.remove(getInstructor(id));
	}


	@Override
	@Transactional
	public Instructor updateInstructor(Instructor inst, int id) {
		entityManager.merge(inst);
		return entityManager.find(Instructor.class, id);
	}
}
