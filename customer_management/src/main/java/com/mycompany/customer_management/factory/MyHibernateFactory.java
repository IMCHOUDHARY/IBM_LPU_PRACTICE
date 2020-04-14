package com.mycompany.customer_management.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.customer_management.domain.Customer;


public class MyHibernateFactory {

	private SessionFactory sessionFactory;

	private static MyHibernateFactory factory;

	private MyHibernateFactory() {

	}

	public SessionFactory getSessionFactory()
	{
		sessionFactory=new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
		return sessionFactory;
	}
	
	public static MyHibernateFactory getMyHibernateFactory()
	{
		if(factory==null)
		{
			factory=new MyHibernateFactory();
		}
		return factory;
	}

}
