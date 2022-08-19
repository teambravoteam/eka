package com.varxyz.eka.schoolscore.domain;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.schoolscore.category.domain.TestSubjectCategory;
import com.varxyz.eka.student.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class SchoolScore {
	private long schoolscoreId;
	private Academy academy;
	private TestSubjectCategory testtpye;
	private Student student;
	private double testScore;
	
	public SchoolScore() {
		
	}


}
