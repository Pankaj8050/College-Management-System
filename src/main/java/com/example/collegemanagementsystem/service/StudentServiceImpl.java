package com.example.collegemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.collegemanagementsystem.dao.StudentRepository;
import com.example.collegemanagementsystem.entity.Student;
import com.example.collegemanagementsystem.exceptions.DataNotFoundException;


@Service
public class StudentServiceImpl implements StudentService {

	StudentRepository studentRepo;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public Student saveAllStudent(Student student) {

		Student result = studentRepo.findByUserName(student.getUserName());
		if (result != null) {
			throw new DataNotFoundException("Username Already registerd, Try with different username ?");
		} else {
			Student thestudent = studentRepo.save(student);
			return thestudent;
		}
	}

	@Override
	public List<Student> findAllStudent() {
		List<Student> allStudent = studentRepo.findAll();
		if (allStudent.size() == 0) {
			throw new DataNotFoundException("Student list is empty !!!");
		}

		return allStudent;
	}

	@Override
	public Student updateStudentById(int id, Student student) {
		Student result = findStudentById(id);
		if (result != null) {
			studentRepo.save(student);
			return student;
		} else
			throw new DataNotFoundException("Student  is not available !!!");

	}

	@Override
	public void deleteStudentById(int id) {
		Optional<Student> result = studentRepo.findById(id);

//		Student student = new Student();
		if (result != null)
			studentRepo.deleteById(id);

		else
			throw new DataNotFoundException("Student is not available !!!");
	}

	@Override
	public Student findStudentByUsernameAndPassword(String username, String password) {

		Student student = studentRepo.findByUserNameAndPassword(username, password);

		if (student == null)
			throw new DataNotFoundException("Invalid Credential !!!");
		return student;
	}

	@Override
	public Student findStudentById(int id) {
		Optional<Student> result = studentRepo.findById(id);

		Student student = null;
		if (result.isPresent()) {
			student = result.get();
		} else {
			throw new DataNotFoundException("Student not found !!, whose ID is " + id);
		}
		return student;
	}

	@Override
	public List<Student> findAllStudentByIdInDesc() {
		List<Student> sortedByDescStudent = studentRepo.findAllByOrderByIdDesc();

		if (sortedByDescStudent.size() == 0) {
			throw new DataNotFoundException("Student list is empty !!!");
		}
		return sortedByDescStudent;
	}
}

