package com.example.collegemanagementsystem.service;

import java.util.List;

import com.example.collegemanagementsystem.entity.Student;




public interface StudentService {
	
	public Student saveAllStudent(Student student);
	public List<Student> findAllStudent();
	public Student updateStudentById(int id,Student student);
	public void deleteStudentById(int id);
	
//	Different method except JPA method[Self implemented.]
	
	public Student findStudentByUsernameAndPassword(String username, String password);
	public List<Student> findAllStudentByIdInDesc();
	public Student findStudentById(int id);
	
}