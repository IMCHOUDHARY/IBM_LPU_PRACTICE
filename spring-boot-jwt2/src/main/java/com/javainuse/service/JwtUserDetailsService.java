package com.javainuse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javainuse.dao.AuthenticationDao;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AuthenticationDao authenticationDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		if (authenticationDao.findByUsername(username).getUsername().equals(username))
		{
			return new User(authenticationDao.findByUsername(username).getUsername() , authenticationDao.findByUsername(username).getPassword(),
							new ArrayList<>());       //ankitchoudhary
		} 
		else
		{
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}