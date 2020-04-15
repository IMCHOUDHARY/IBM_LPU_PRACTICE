package com.mycompany.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.one_to_one.entity.ProjectDetail;
import com.mycompany.one_to_one.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(ProjectDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.openSession();
		try {			
			
			// create the objects
			/*
			Instructor tempInstructor = 
					new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.luv2code.com/youtube",
							"Luv 2 code!!!");		
			*/
			
			Student tempStudent = 
					new Student("ankit", "choudhary", "xyz@gmail.com");
			
			ProjectDetail tempProjectDetail =
					new ProjectDetail(
							"cs",
							"Done");		
			
			// associate the objects
			tempStudent.setProjectDetail(tempProjectDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving student: " + tempStudent);
			session.save(tempStudent);					
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
