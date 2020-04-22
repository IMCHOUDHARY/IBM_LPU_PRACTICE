package comm.example.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import comm.example.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private SessionFactory sessionFactory;
	private EntityManagerFactory factory;
	private EntityManager entityManager;

	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@PostConstruct
	public void init()
	{
		factory=sessionFactory.unwrap(SessionFactory.class);
		entityManager=factory.createEntityManager();
	}
	
	
	// need to inject the session factory
		//@Autowired
		//private SessionFactory sessionFactory;
	
	/*@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.openSession();
		
				
		// create a query  ... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",
											Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}*/
	

	@Override
	public List<Customer> getCustomers() 
	{
		return entityManager.createQuery("from Customer order by lastName", Customer.class).getResultList();
	}
		
	@Override
	public Customer findById(int id)
	{
		Customer cust = entityManager.find(Customer.class, id);
		if(cust==null)
			return null;
		return cust;
	}

	@Override
	public Customer updateById(int id, String firstName, String lastName, String email) {
		Customer cust = entityManager.find(Customer.class, id);
		if(cust==null)
			return null;
		cust.setFirstName(firstName);
		cust.setLastName(lastName);
		cust.setEmail(email);
		entityManager.getTransaction().begin();
		entityManager.merge(cust);
		entityManager.getTransaction().commit();
		return cust;
	}

	@Override
	public Customer addCustomer(Customer theCust) {
		entityManager.getTransaction().begin();
		entityManager.persist(theCust);
		entityManager.getTransaction().commit();
		return theCust;
	}

	@Override
	public Customer deleteById(int custId) {
		Customer cust = findById(custId);
		entityManager.getTransaction().begin();
		entityManager.remove(cust);
		entityManager.getTransaction().commit();
		return cust;
	}
	

}
