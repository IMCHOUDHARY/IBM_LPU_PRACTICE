package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {

	@Id
	public int id;
	public String name;
	public String about;
	
	public Users()
	{
		
	}

	public Users(int id, String name, String about) {
		super();
		this.id = id;
		this.name = name;
		this.about = about;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", about=" + about + "]";
	}
	
}
