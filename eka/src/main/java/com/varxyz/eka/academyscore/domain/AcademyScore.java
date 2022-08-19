package com.varxyz.eka.academyscore.domain;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.student.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter  
@Setter
@ToString
@AllArgsConstructor
public class AcademyScore {
	private long academyScoreId;
	private Academy academy;
	private Student student;
	private double testScore;
	
	public AcademyScore() {
		
	}
	

}
