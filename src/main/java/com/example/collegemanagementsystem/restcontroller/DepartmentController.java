package com.example.collegemanagementsystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.collegemanagementsystem.entity.Department;
import com.example.collegemanagementsystem.service.DepartmentService;

@RestController
@RequestMapping("/department")

public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/add")
	public void addDepartment(@RequestBody Department department) {

		
		departmentService.addDepartment(department);
	}
  
	
	@GetMapping(value="/list")
	public List<Department> getAllDepartment(){
		return departmentService.getAllDepartment();
	}
	
	@PutMapping(value="/update")
	public void updateDepartment(@RequestBody Department department) {
		departmentService.updateDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") int id) throws Exception {
		return departmentService.getDepartment(id);
	}
	
	@GetMapping("department/{name}") // Ok
	private List<Department> getDepartmentByName(@PathVariable String name) throws Exception {
		List<Department> department = departmentService.getDepartmentByName(name);
		
		return department;
	}
	
	
	

}
