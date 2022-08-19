package com.varxyz.eka.schoolscore.category.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TestSubjectCategory {
	private long testSubjectId;
	private TestTypeCategory testType;
	private String testSubject;
	
	public TestSubjectCategory() {
		
	}

}
