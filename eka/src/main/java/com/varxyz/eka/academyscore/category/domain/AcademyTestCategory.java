package com.varxyz.eka.academyscore.category.domain;

import java.sql.Date;

import com.varxyz.eka.academy.lecture.domain.Lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AcademyTestCategory {
	private long testcategoryId;
	private Lecture lecture;
	private String testname;
	private Date testDate;
	
	public AcademyTestCategory() {
		
	}
  
}
