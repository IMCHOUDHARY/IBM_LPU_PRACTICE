package comm.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import comm.example.dao.CustomerDAO;
import comm.example.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
		@Autowired
		private CustomerDAO customerDAO;
		
		@Override
		@Transactional
		public List<Customer> getCustomers() {
			return customerDAO.getCustomers();
		}

		@Override
		public Customer findById(int id) {
			// TODO Auto-generated method stub
			return customerDAO.findById(id);
		}

		@Override
		public Customer updateById(int id, String firstName, String lastName, String email) {
			// TODO Auto-generated method stub
			return customerDAO.updateById(id, firstName, lastName, email);
		}

		@Override
		public Customer addCustomer(Customer theCust) {
			// TODO Auto-generated method stub
			return customerDAO.addCustomer(theCust);
		}

		@Override
		public Customer deleteById(int custId) {
			// TODO Auto-generated method stub
			return customerDAO.deleteById(custId);
		}


}
