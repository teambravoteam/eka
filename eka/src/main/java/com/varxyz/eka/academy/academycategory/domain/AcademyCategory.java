package com.varxyz.eka.academy.academycategory.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor	
public class AcademyCategory {
	private String ageCategory;
	private String mainSubjectCategory;
	private String subjectCategory;
	
	public AcademyCategory() {
		
	}
}

