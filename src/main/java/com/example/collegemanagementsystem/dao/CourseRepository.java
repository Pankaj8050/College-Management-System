package com.example.collegemanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.collegemanagementsystem.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	List<Course> findAllByTermIgnoreCase(String term); 
	List<Course> findAllByYearIgnoreCase(String year);
//	List<Course> findAllByInstructorIgnoreCase(int id);
	
	List<Course> findAllByYearAndTermIgnoreCase(String year , String term);
	Course findById(int id);
	 
}
