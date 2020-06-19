package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Course;
import com.app.repository.CourseRepository;

@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	CourseRepository repository;

	
	@RequestMapping(value = "/getAllCourses", method = RequestMethod.GET)
	public List<Course> getAllCourses() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/getCourses/{coursename}", method = RequestMethod.GET)
	public List<Course> getCourseByName(@PathVariable("coursename") String companyname) {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/getCourseById/{id}", method = RequestMethod.GET)
	public Course getCourseById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public Course addCourse(@RequestBody Course jobPost) {
		System.out.println("***************   "+ jobPost);
		return repository.save(jobPost);
	}

	@RequestMapping( value = "/updateCourse/{id}" , method=RequestMethod.PUT)
	public Course updateJobPosting(@PathVariable Long id, @RequestBody Course c) {
		Course course = repository.findById(id).get();
		if(c !=null) {
			course.setCname(c.getCname());
			course.setDuration(c.getDuration());
			course.setFee(c.getFee());
			course.setSdate(c.getSdate());
			return repository.save(course);
		}
		return null;
	}

	@DeleteMapping("/deleteCourse/{id}")
	public void deleteCourse(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
}
