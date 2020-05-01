package com.example.demo.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Account {

	private int id;
	private String name;
	private int amount;
}
