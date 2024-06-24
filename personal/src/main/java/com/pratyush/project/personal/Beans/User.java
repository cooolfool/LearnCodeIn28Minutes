package com.pratyush.project.personal.Beans;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

	private Integer id;
	
	@Size(min=2, message = "Name should be atleast 2 characters")
	private String name;
	@Past(message =  "DOB should be of past date")
	private LocalDate dob;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public User(Integer id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
}
