package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Course;
import com.sms.model.Skill;
import com.sms.model.Student;
import com.sms.repository.CourseRepo;
import com.sms.service.StudentService;
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@Autowired
	private CourseRepo courseRepo;
	

	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student,
			@RequestParam("coursename") List<String> courseName) {
		
		
		
		
		List<Course> courses= courseRepo.findByCoursenameIn(courseName);
	
		student.setCoursename(courses);
		
		List<Skill> skills = student.getSkill();
		
		for(Skill skill:skills) {
			skill.setStudent(student);
		}
		
		
		
		
		
		
		return studentService.addStudent(student);
	}
}
