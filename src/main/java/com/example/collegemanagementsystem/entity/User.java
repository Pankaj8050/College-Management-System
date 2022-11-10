package com.example.collegemanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name ="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true,nullable=false, name = "id")
	private int id;
	

	@Column(length=255,name="address")
	private String address;

	@Column(length=255,name="age")
	private int age;

	@Column(length=255 , name = "email")
	@Email
	private String email;

	@Column(length=255,name = "first_name")
	private String firstName;
    
	@Column(length=255,name = "last_name")
	private String lastName;
	
	@Column(length=255 , name="gender")
	private String gender;
	
	@Column(name ="phno")
	@NotBlank(message = "Phone number must be required.")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Invalid Number") 
	private String phoneNumber;
	
	@Column(name="user_name", length=255)
	private String userName;

	@Column(name ="password")
	@Size(min = 4, max = 10, message = "Password length must be 4 to 10.")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User() {
		super();
	}

	public User(int id, String address, int age, @Email String email, String firstName, String lastName, String gender,
			@NotBlank(message = "Phone number must be required.") @Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid Number") String phoneNumber,
			String userName, @Size(min = 4, max = 10, message = "Password length must be 4 to 10.") String password,
			Department department) {
		super();
		this.id = id;
		this.address = address;
		this.age = age;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	

}
