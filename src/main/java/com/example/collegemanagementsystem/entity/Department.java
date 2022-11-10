package com.example.collegemanagementsystem.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "department")
//@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department {
	

	@Id
	@SequenceGenerator(name="DEPARTMENT_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTMENT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private int id;
	
	@Column(name="head", length=255)
	private String head;
	
	@Column(name="contact_email", length=255)
	private String contactEmail;

	@Column(name="contact_phone", length=255)
	private String contactPhone;

	@Column(length=255)
	private String name;
	
	@OneToMany
	private Set<Course> course;
	
	@OneToMany
	private Set<User> user;

	public Department() {
		super();
	}

	public Department(int id, String head, String contactEmail, String contactPhone, String name, Set<Course> course,
			Set<User> user) {
		super();
		this.id = id;
		this.head = head;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.name = name;
		this.course = course;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
	
	
	
	

}
