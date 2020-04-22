package comm.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comm.example.entity.Customer;
import comm.example.exception.CustomerNotFoundException;
import comm.example.exception.CustomerResponseEntity;
import comm.example.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/test")
	public String test()
	{
		return "It is working fine!!!!";
	}
	
	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
		
	}
	
	
	@GetMapping("/customers/{custId}")
	public Customer findById(@PathVariable int custId) throws CustomerNotFoundException
	{
		Customer cust = customerService.findById(custId);
		if(cust==null)
			throw new CustomerNotFoundException("Customer not found with ID: "+custId);
		return cust;
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerResponseEntity> handleException(CustomerNotFoundException snfe)
	{
		return new ResponseEntity<CustomerResponseEntity>(new CustomerResponseEntity(HttpStatus.NOT_FOUND.value(), snfe.getMessage(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerResponseEntity> handleNumberFormatException(NumberFormatException ipme)
	{
		return new ResponseEntity<CustomerResponseEntity>(new CustomerResponseEntity(HttpStatus.BAD_REQUEST.value(),"must provide numeric value", System.currentTimeMillis()),HttpStatus.BAD_REQUEST);
	}
		
	
	
	@PutMapping("/customers/update")
	public Customer updateById(@RequestParam int id,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email) throws CustomerNotFoundException
	{
		Customer cust = customerService.updateById(id,firstName,lastName,email);
		if(cust==null)
			throw new CustomerNotFoundException("Customer not found with ID: "+id);
		return cust;
	}
	
	
	@PostMapping("/customers/add_customer")
	public Customer addCustomer(@RequestBody Customer theCust)
	{
		return customerService.addCustomer(theCust);
	}
	
	
	@DeleteMapping("/customers/delete/{custId}")
	public Customer deleteById(@PathVariable int custId)
	{
		return customerService.deleteById(custId);
	}
}
