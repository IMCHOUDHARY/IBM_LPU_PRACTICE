package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.MyUser;

@Controller
public class UserController {

	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping(value = "/register-user")
	public String register(MyUser myUser) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(myUser.getRoles()));
		String encodededPassword = passwordEncoder.encode(myUser.getPassword());
		User user = new User(myUser.getUserName(), encodededPassword, authorities);
		jdbcUserDetailsManager.createUser(user);
		return "User created :)";
	}

	@RequestMapping("/register")
	public String addUser(Model model)
	{
		model.addAttribute("user", new MyUser());
		return "userForm";
	}
	
	@RequestMapping(value = "/admin")
	public String admin(Model model) {
		model.addAttribute("employee",new Employee());
		return "adminpage";
	}
	

	@GetMapping(value = "/user")
	public String user() 
	{
		return "userpage";
	}

	@GetMapping(value = "/")
	public String welcome() {
		return "<h3>Welcome :)</h3>";
	}
}