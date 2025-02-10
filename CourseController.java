package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.dto.CourseDTO;
import com.api.entity.Course;
import com.api.service.CourseService;


@RestController
public class CourseController {

	@Autowired
	private CourseService courseservice;
	
	@PostMapping("/addcourse")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseservice.addCourse(course);
	}
	
	
	@GetMapping("/getAllCourse")
	public List<CourseDTO> getAllCourse(){
		
		return this.courseservice.getAllCourse();
	}
	
	@GetMapping("/getCourse/{id}")
	public CourseDTO getCourseById(@PathVariable Long id) {
		
		return this.courseservice.getCourse(id);
	}
	
	
	@PutMapping("/updateCourse/{id}")
	public CourseDTO updateCourseById(@PathVariable Long id , @RequestBody CourseDTO coursedto) {
		
		return this.courseservice.updateCourseById(id, coursedto);
	}
	
	
	@DeleteMapping("/deleteCourse/{id}")
	public CourseDTO deleteById(@PathVariable Long id) {
		
		return this.courseservice.deleteCourse(id);
	}
}
