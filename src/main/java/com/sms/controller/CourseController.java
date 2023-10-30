package com.sms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Course;
import com.sms.model.Student;
import com.sms.repository.StudentRepo;
import com.sms.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	
	@Autowired
	private StudentRepo studentRepo;
	
	@PostMapping("/addCourse/{name}")
	public Course addCourse(@RequestBody Course course,@PathVariable(value="name") String name) {
		
		List<Student> listStudents= studentRepo.findByStudentname(name);
		
		List<Course> courses=new ArrayList<>();
		courses.add(course);
		for(Student student:listStudents) {
			student.setCoursename(courses);
		}
		course.setStudent(listStudents);
		
		
		return courseService.addCourse(course);
	}
	
	@GetMapping("/getAllCourses")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}

}
