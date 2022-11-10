package com.example.collegemanagementsystem.restcontroller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.collegemanagementsystem.entity.Student;
import com.example.collegemanagementsystem.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	 private StudentService studentService;
	 
	 @Autowired
	 public StudentRestController(StudentService studentService)
	 {
		 this.studentService=studentService;
	 }

	@PostMapping("/students") // Ok
	private Student saveStudent(@Valid @RequestBody Student theStudent) {

		Student student = studentService.saveAllStudent(theStudent);		
		return student;
	}

	@GetMapping("/students")  //Ok
	private List<Student> getAllStudent() {
		List<Student> studentList = studentService.findAllStudent();
		return studentList;
	}

	@GetMapping("students/{id}") // Ok
	private Student getStudentById(@PathVariable int id) {
		Student student = studentService.findStudentById(id);
		
		return student;
	}


	@GetMapping("students/byDesc") // Ok
	private List<Student> findAllByOrderByIdDesc() {
		List<Student> sortedByDescStudent = studentService.findAllStudentByIdInDesc();
		return sortedByDescStudent;
	}

	@GetMapping("students/login/{username}/{password}") // Ok
	private Student loginStudent(@PathVariable String username, @PathVariable String password) {

		Student getValidStudent = studentService.findStudentByUsernameAndPassword(username, password);

		System.out.println(getValidStudent.getUserName());
		return getValidStudent;
	}

	@PutMapping("/students")   //
	private Student updateStudent(@Valid @RequestBody Student student) {

		Student thestudent = studentService.findStudentById(student.getId());

		System.out.println("OK");
		Student result = studentService.updateStudentById(thestudent.getId(), student);
		return result;

	}
	
	@DeleteMapping("students/{id}") 
	private String deleteStudent(@PathVariable int id) {

		Student student = studentService.findStudentById(id);
		
		studentService.deleteStudentById(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK)+"\nDeleted";
	}
	
	

}
