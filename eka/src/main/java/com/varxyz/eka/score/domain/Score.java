package com.varxyz.eka.score.domain;

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
public class Score {
	private ScoreCategory scoreCategory;
	private double testScore;
	private String testDate;
	private Student student;
	private Academy academy;
	
	public Score() 	{
		
	}

}
