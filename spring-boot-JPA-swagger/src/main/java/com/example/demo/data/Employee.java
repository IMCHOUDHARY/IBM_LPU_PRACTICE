package com.example.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "employee")
@ApiModel(description="All details about the Employee. ")
public class Employee {
	@ApiModelProperty(notes = "The database generated employee ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int employeeID;
	
	@ApiModelProperty(notes = "The employee first name")
	@Column(name = "first_name")
	private String firstName;
	
	@ApiModelProperty(notes = "The employee last name")
	@Column(name = "last_name")
	private String last_name;
	
	@ApiModelProperty(notes = "The employee email")
	@Column(name="email")
	private String email;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String last_name, String email) {
		super();
		this.firstName = firstName;
		this.last_name = last_name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", last_name=" + last_name
				+ ", email=" + email + "]";
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
