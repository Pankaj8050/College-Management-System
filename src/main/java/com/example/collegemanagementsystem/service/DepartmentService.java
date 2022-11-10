package com.example.collegemanagementsystem.service;

import java.util.List;

import com.example.collegemanagementsystem.entity.Department;

public interface DepartmentService {
	
	void addDepartment(Department department);
	void updateDepartment(Department department);
	Department getDepartment(int id) throws Exception;
	List<Department> getDepartmentByName(String name) throws Exception;
	List<Department> getAllDepartment();
	
}
