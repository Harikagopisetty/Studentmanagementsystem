package com.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	List<Student>  findByStudentname(String name);
}
