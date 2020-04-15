package com.mycompany.one_to_one_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.one_to_one_bi.entity.ProjectDetail;
import com.mycompany.one_to_one_bi.entity.Student;

public class FetchDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(ProjectDetail.class)
								.buildSessionFactory();
		
		Session session = factory.openSession();
		try {			
			
			////   Student ----->  ProjectDetail
			/*Student tempStudent = null;
			tempStudent = session.get(Student.class, 1);
			System.out.println(tempStudent);
			ProjectDetail project = tempStudent.getProjectDetail();
			System.out.println(project);
			System.out.println("Done!");*/
			
			//// ProjectDetail ----->  Student
			ProjectDetail project = null;
			project = session.get(ProjectDetail.class, 1);
			System.out.println(project);
			Student tempStudent = project.getStudent();
			System.out.println(tempStudent);
			System.out.println("Done!");
			
			
		}
		finally {
			factory.close();
		}
	}
}

