package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Account")
@ApiModel(description="All details about the Account. ")
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Account {
	@ApiModelProperty(notes = "The database generated employee ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@ApiModelProperty(notes = "Customer Name")
	private String name;
	@ApiModelProperty(notes = "Customer's Account Balance")
	private int amount;
}
