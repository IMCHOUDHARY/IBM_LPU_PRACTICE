package com.mycompany.customer_management.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.customer_management.domain.Customer;
import com.mycompany.customer_management.factory.MyHibernateFactory;

public class CustomerDAOImpl implements CustomerDAO {

	private  MyHibernateFactory factory=null;
	private SessionFactory sessionFactory=null;
	private Session session=null;
	
	{
		factory=MyHibernateFactory.getMyHibernateFactory();
		sessionFactory=factory.getSessionFactory();
		session=sessionFactory.getCurrentSession();
	}

	public Customer createCustomer(Customer customer) {
		
		session.getTransaction().begin();
		session.save(customer);
		session.getTransaction().commit();
	//	session.close();
		return customer;
	}

	public List<Customer> getAllCustomer() {
		session.getTransaction().begin();
		List<Customer> list=session.createQuery("from Customer",Customer.class).list();
		session.getTransaction().commit();
		return list;
	}

	public Customer getCustomerByID(String customerID) {
		// TODO Auto-generated method stub
		return session.get(Customer.class, customerID);
	}


}
