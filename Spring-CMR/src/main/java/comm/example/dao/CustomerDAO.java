package comm.example.dao;

import java.util.List;

import comm.example.entity.Customer;

public interface CustomerDAO {

	
	  public List<Customer> getCustomers();
	  
	  public Customer findById(int id);
	  
	  public Customer updateById(int id, String firstName, String lastName, String email);
	  
	  public Customer addCustomer(Customer theCust);

	  public Customer deleteById(int custId);
	  
	  
		/*
		 * public void saveCustomer(Customer theCustomer);
		 * 
		 * public Customer getCustomer(int theId);
		 * 
		 * public void deleteCustomer(int theId);
		 */
}
