package com.example.collegemanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true,nullable=false, name = "id")
	private int id;
	
	@Column(unique = true,name = "user_name")
	@NotBlank(message = "username must be required")
	@Size(min = 3, max = 10, message = "Username consists of atleast 3 characters !!!")
	private String userName;
	
	@Column(name ="first_name")
	@NotBlank(message = "Firstname must be required")
	private String firstName;
	
	@Column(name ="last_name")
	@NotBlank(message = "Lastname must be required")
	private String lastName;

	@Column(name ="email")
	@NotBlank
	@Email
	private String email;
	
	@Column(name ="password")
	@Size(min = 4, max = 10, message = "Password length must be 4 to 10.")
	private String password;
	
	@Column(name ="phno")
	@NotBlank(message = "Phone number must be required.")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Invalid Number") 
	private String phoneNumber;
	
	@Column(name ="gender")
	private String gender;
	
	@Column(name ="percentage")
	private int percentage;
	
	@Column(name ="status")
	private String status;

	public Student() {
		super();
	}

	public Student(int id,
			@NotBlank(message = "username must be required") @Size(min = 3, max = 10, message = "Username consists of atleast 3 characters !!!") String userName,
			@NotBlank(message = "Firstname must be required") String firstName,
			@NotBlank(message = "Lastname must be required") String lastName, @NotBlank @Email String email,
			@Size(min = 4, max = 10, message = "Password length must be 4 to 10.") String password,
			@NotBlank(message = "Phone number must be required.") @Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid Number") String phoneNumber,
			String gender, int percentage, String status) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.percentage = percentage;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + ", gender=" + gender
				+ ", percentage=" + percentage + ", status=" + status + "]";
	}
	
	
}

	




	
