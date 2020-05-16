package com.ezeeshop.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Customers")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	private String name;
	private String username;
	private String password;
	private String mobileNo;
	private String imageUrl;
	
	public User() {
		
	}
	
	public User(String name, String username, String password, String mobileNo, String imageUrl) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.mobileNo = mobileNo;
		this.imageUrl = imageUrl;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "User [custId=" + custId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", mobileNo=" + mobileNo + ", imageUrl=" + imageUrl + "]";
	}
	
	
}
