package com.varxyz.eka.attendence.domain;

import java.sql.Date;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.student.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Attendence {
	private Student student;
	private String checking;
	private Lecture lecture;
	private Academy academy;
	private Date regDate; 
	
	public Attendence() {
		
	}

}
