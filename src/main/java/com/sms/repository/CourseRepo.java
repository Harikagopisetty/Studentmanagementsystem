package com.sms.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

	Course findByCoursename(String coursename);
	
	List<Course> findByCoursenameIn(Collection<String> courses);

}
