package com.varxyz.eka.student.studentcategory.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class GradeCategory {
	private long ssid;
	private SchoolCategory schoolcate;
	private String gradecate;
	
	public GradeCategory() {
		
	}
}
