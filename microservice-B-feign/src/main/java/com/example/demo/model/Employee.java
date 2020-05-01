package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Employee {

	@Id
	private int id;
	private String name;
	private String departmentName;
	public Employee(int id,String name, String departmentName) {
		super();
		this.id=id;
		this.name = name;
		this.departmentName = departmentName;
	}
	
	
}
