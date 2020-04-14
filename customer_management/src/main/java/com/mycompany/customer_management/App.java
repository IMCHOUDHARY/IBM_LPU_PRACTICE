package com.mycompany.customer_management;

import java.util.List;
import java.util.Scanner;

import com.mycompany.customer_management.domain.Customer;
import com.mycompany.customer_management.service.CustomerService;
import com.mycompany.customer_management.service.CustomerServiceImpl;

public class App {
	private static CustomerService service = null;
	private static Scanner scanner = new Scanner(System.in);
	static {
		service = new CustomerServiceImpl();
	}

	public static void main(String[] args) {
		int id;
		String fName, lName, email;
		int choice = -1;
		do {
			System.out.println("1. Create Customer");
			System.out.println("2. Display All Available Customer");
			System.out.println("3. Display Customer BY ID");
			System.out.print("enter your choice:  ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the id:");
				id = scanner.nextInt();
				System.out.print("Customer First Name: ");
				fName = scanner.next();
				System.out.print("Customer Lastst Name: ");
				lName = scanner.next();
				System.out.print("Customer Email: ");
				email = scanner.next();
				Customer customer = new Customer();
				customer.setId(id);
				customer.setFirstName(fName);
				customer.setLastName(lName);
				customer.setEmail(email);
				//customer.setId(UUID.randomUUID().toString());
				customer = service.createCustomer(customer);
				System.out.println(customer);
				break;
			case 2:
				List<Customer> list = service.getAllCustomer();
				for (Customer s : list) {
					System.out.println(s);
				}
				break;
			case 3:
				System.out.print("Enter Customer ID: ");
				customer = service.getCustomerByID(scanner.next());
				if (customer == null) {
					System.out.println("No Such Customer Found With given ID: ");
				} else {
					System.out.println(customer);
				}
				break;
			case 0:
				System.out.println("Bye!!");
				System.exit(0);
			default:
				System.out.println("Invalid Choice.");
				break;
			}

		} while (choice != 0);

		/*
		 * try {
		 * 
		 * SessionFactory factory=new
		 * Configuration().configure().addAnnotatedClass(Customer.class).
		 * buildSessionFactory(); Session session=factory.openSession(); Customer
		 * customer=new Customer(); customer.setId(UUID.randomUUID().toString());
		 * customer.setFirstName("John"); customer.setLastName("Doe");
		 * customer.setEmail("john@demo.com"); session.getTransaction().begin();
		 * session.save(customer); session.getTransaction().commit();
		 * System.out.println("One Item Saved Successfully..!");
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 */
	}
}
