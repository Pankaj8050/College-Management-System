package com.example.collegemanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.collegemanagementsystem.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	List<Department> getDepartmentByName(String name);
	//List<Department> getAllDepartment();
	List<Department> findByName(String name);
}
