package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.model.Student;
import com.sms.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	public List<Student>  getAllStudent(){
		return studentRepo.findAll();
	}
	
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

}
