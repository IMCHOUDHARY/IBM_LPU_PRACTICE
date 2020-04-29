package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsersDAO;
import com.example.demo.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {

	public UsersDAO usersDAO;
	
	@Autowired
	public UsersServiceImpl(UsersDAO usersDAO) {
		super();
		this.usersDAO = usersDAO;
	}


	@Override
	public Users findUserById(int id) {
		// TODO Auto-generated method stub
		return usersDAO.findById(id).get();
	}

}
