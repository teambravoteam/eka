package com.varxyz.eka.schoolscore.category.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TestTypeCategory {
	
	private long testTypeId;
	private String testType;
	
	public TestTypeCategory() {
		
	}

}
