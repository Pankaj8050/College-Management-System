package com.example.collegemanagementsystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.collegemanagementsystem.entity.Course;
import com.example.collegemanagementsystem.service.CourseService;

@RestController
@RequestMapping("/courses")

public class CourseRestController {

	@Autowired
	CourseService courseService;
	
	@PostMapping("/add")
	public void addcourse(@RequestBody Course course) {

		
		courseService.addCourse(course);
	}
	
	@GetMapping(value="/list")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@PutMapping(value="/update")
	public void updateCourse(@RequestBody Course course) {
		courseService.updateCourse(course);
	}
	
	@GetMapping("/{id}")
	public Course  getCourse(@PathVariable("id") int id) {
		return courseService.getCourse(id);
	}
	
	@GetMapping("/byterm/{term}")
	public List<Course>  getAllCourseByTermName(@PathVariable("term") String term) {
		return courseService.getAllCoursesByTerm(term);
	}
	
	@GetMapping("/byyear/{year}")
	public List<Course>  getAllCourseByYearName(@PathVariable("year") String year) {
		return courseService.getAllCoursesByYear(year);
	}
	
	
	@GetMapping("/byyearandterm")
	public List<Course>  getAllCourseByYearANDTerm(@RequestParam String year, @RequestParam String term)  {
		System.out.println(year + " and " + term);
		return courseService.getAllCoursesByYearANDTermIgnoreCase(year, term);
	}
	
	
	@DeleteMapping("/course/release/{id}")
	public void releaseCourse(@PathVariable int id) {
		courseService.deleteCourse(id);
	}

}
