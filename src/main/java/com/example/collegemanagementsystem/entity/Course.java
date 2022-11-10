package com.example.collegemanagementsystem.entity;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true,nullable=false, name = "course_id")
	private int id;
	
	@Column(length=255)
	private String name;
	
	@Column(length=255)
	private String term;
	

	@Column
	private String code ; 


	@Column(length=255)
	private String year;
	
	@ManyToOne
	private Department department;
	
	@ManyToOne
	private User user;


	public Course() {
		super();
	}


	public Course(int id, String name, String term, String code, String year, Department department, User user) {
		super();
		this.id = id;
		this.name = name;
		this.term = term;
		this.code = code;
		this.year = year;
		this.department = department;
		this.user = user;
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


	public String getTerm() {
		return term;
	}


	public void setTerm(String term) {
		this.term = term;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	

}
