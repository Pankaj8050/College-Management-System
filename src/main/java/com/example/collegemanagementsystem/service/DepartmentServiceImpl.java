package com.example.collegemanagementsystem.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.collegemanagementsystem.dao.DepartmentRepository;
import com.example.collegemanagementsystem.entity.Department;
@Service
public class DepartmentServiceImpl implements DepartmentService {
      
	@Autowired
	 public DepartmentRepository departmentRepository;
	
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public void addDepartment(Department department) {
		// TODO Auto-generated method stub
		 departmentRepository.save(department);
		
	}

	@Override
	public void updateDepartment(Department department) {
		departmentRepository.save(department);
		
	}

	@Override
	public Department getDepartment(int id) throws Exception {
	    Optional<Department> result = departmentRepository.findById(id);
		
		Department department;
		if(result.isPresent())
		{
			department = result.get();
		}
		else {
			throw new Exception("department id not found : "+id);
		}
		return department;
	}

	@Override
	public List<Department> getDepartmentByName(String name) throws Exception {
       List<Department> department = departmentRepository.findByName(name);
		
	
		if(department.isEmpty())
		{
			throw new Exception("department name not found : "+name);
		}
		
		return department;
	}

	@Override
	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}
	
	 
	 
}
