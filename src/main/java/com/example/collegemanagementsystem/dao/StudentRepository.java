package com.example.collegemanagementsystem.dao;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.collegemanagementsystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	Student findByUserNameAndPassword(String username, String password);

	Student findByUserName(String userName);

	List<Student> findAllByOrderByIdDesc();
	
	

}
