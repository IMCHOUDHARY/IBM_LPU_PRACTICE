package com.mycompany.many_to_many.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_detail")
public class ProjectDetail {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="status")
	private String status;
	
	/*@ManyToOne
	@JoinColumn(name="employee_id")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}*/

	@ManyToMany
	private Collection<Student> empList = new ArrayList<Student>();
	
	public Collection<Student> getEmpList() {
		return empList;
	}

	public void setEmpList(Collection<Student> empList) {
		this.empList = empList;
	}

	public ProjectDetail() {
		
	}

	public ProjectDetail(String projectName, String status) {
		this.projectName = projectName;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProjectDetail [id=" + id + ", projectName=" + projectName + ", status=" + status + "]";
	}



}
