package com.varxyz.eka.student.studentcategory.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SchoolCategory {
	private long smid;
	private String schoolcate;
	
	public SchoolCategory() {
		
	}
}
