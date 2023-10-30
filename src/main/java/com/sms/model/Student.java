package com.sms.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String studentname;
	
	private int age;
	
	private String collegename;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_Fk")
	private Branch  branchname;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "studentcourse", joinColumns = { @JoinColumn(name = "Student_id") },inverseJoinColumns = {@JoinColumn(name="course_id")}
	)
	@JsonIgnore
	private List<Course> coursename;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
	private List<Skill> skill;
	
}
