package com.mycompany.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.one_to_many.entity.ProjectDetail;
import com.mycompany.one_to_many.entity.Student;

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
			Student student = new Student();
			student.setFirstName("honey");
			student.setLastName("choudhary");
			student.setEmail("mnq@gmail.com");
			
			ProjectDetail project1 = new ProjectDetail();
			project1.setProjectName("english");
			project1.setStatus("Done");
			
			ProjectDetail project2 = new ProjectDetail();
			project2.setProjectName("maths");
			project2.setStatus("Done");
			
			student.getProjectDetail().add(project1);
			student.getProjectDetail().add(project2);
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
