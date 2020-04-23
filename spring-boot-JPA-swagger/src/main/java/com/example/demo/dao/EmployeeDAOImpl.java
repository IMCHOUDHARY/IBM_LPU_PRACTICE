package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.Employee;


@Repository(value="employeeDAO")
@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		
		Session session=entityManager.unwrap(Session.class);
		
		Query query=session.createQuery("from Employee",Employee.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.save(employee);
		return employee;
	}

	@Override
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	@Transactional
	public Employee deleteEmployee(int employeeId) {
		Employee e = entityManager.find(Employee.class, employeeId);
		entityManager.remove(e);
		return e;
	}

}
