package com.varxyz.eka.parent.domain;

import com.varxyz.eka.student.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Parent {
	private String name;
	private String ssn;
	private String phone;
	private Student student;
	
	public Parent() {
		
	}
	

}
