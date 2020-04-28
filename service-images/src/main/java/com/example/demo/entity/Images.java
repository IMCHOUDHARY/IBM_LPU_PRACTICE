package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Images")
public class Images {

	@Id
	public Integer id;
	public String name;
	public String discription;
	
	public Images() {
		
	}
	
	public Images(Integer id, String name, String discription) {
		super();
		this.id = id;
		this.name = name;
		this.discription = discription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "Images [id=" + id + ", name=" + name + ", discription=" + discription + "]";
	}
	
}
