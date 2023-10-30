package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.model.Course;
import com.sms.repository.CourseRepo;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepo courseRepo;
	
	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}
	
	public List<Course> getAllCourses(){
		return courseRepo.findAll();
	}

}
