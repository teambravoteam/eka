package com.varxyz.eka.academy.teacher.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SubjectCategory {
	private long scid;
	private String subjectcate;
	
	public SubjectCategory() {
		
	}
}
