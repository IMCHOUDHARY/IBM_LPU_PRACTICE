package com.IBM.spring_basics;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{
	public void drive()
	{
		System.out.println("Bike is working fine!!!!!");
	}
}
