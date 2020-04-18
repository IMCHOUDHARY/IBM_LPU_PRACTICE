package com.mycompany.spring_JPA;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.spring_JPA.dao.EmployeeDAO;
import com.mycompany.spring_JPA.dao.EmployeeDAOImpl;
import com.mycompany.spring_JPA.entity.Employee;
import com.mycompany.spring_JPA.service.EmployeeService;
import com.mycompany.spring_JPA.service.EmployeeServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	//EmployeeDAO dao=context.getBean("dao",EmployeeDAOImpl.class);
    	//Employee e=dao.createEmployee(new Employee("John", 10000));
    	
    	/*EmployeeService service=context.getBean("service" , EmployeeServiceImpl.class);
    	Employee e=service.createEmployee(new Employee("ankit",20000));
    	
    	System.out.println("done!"+e);*/
    	
    	/*
		 * Employee e = dao.createEmployee(new Employee("Sachin", 20000));
		 * System.out.println("done!" + e);
		 */
    	
    	EmployeeService service = context.getBean("service", EmployeeServiceImpl.class);
    	
    	/*Employee e = service.findEmployee(1);
    	System.out.println(e);*/
    	
		// dao.removeEmployee(1);

		/*Employee employee = service.raiseEmployeeSalary(2, 1000);
		if (employee == null) {
			System.out.println("raise salary aborted.");
		} else {
			System.out.println("Updated Employee: " + employee);
		}*/

		/*Collection<Employee> collection = service.findAllEmployees();
		for (Employee e : collection) {
			System.out.println(e);
		}*/

		Employee e = null;
		String name;
		int salary,id;
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("1. Create Employee");
			System.out.println("2. Remove Employee");
			System.out.println("3. Increase the Salary");
			System.out.println("4. Find Employee");
			System.out.println("5. Find All the Employees");
			ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter name:");
				name = sc.next();
				System.out.println("Enter salary:");
				salary = sc.nextInt();
				e = service.createEmployee(new Employee(name , salary));
				System.out.println(e);
				break;
				
			case 2:
				System.out.println("Enter id to be deleted:");
				id = sc.nextInt();
				service.removeEmployee(id);
				break;
				
			case 3:
				System.out.println("Enter the id:");
				id = sc.nextInt();
				System.out.println("Enter the salary amount increase:");
				salary = sc.nextInt();
				e = service.raiseEmployeeSalary(id, salary);
				System.out.println(e);
				break;
				
			case 4:
				System.out.println("Enter the id of employee to find:");
				id = sc.nextInt();
				e = service.findEmployee(id);
				System.out.println(e);
				break;
				
			case 5:
				System.out.println("Get All Employee:");
				Collection<Employee> ls = service.findAllEmployees();
				for (Employee e1 : ls) {
					System.out.println(e1);
				}
				break;
				
			default:
				System.out.println("Wrong choice entered!!!!!!!!!");
			}
			
		}while(ch!=6);
    }
}
