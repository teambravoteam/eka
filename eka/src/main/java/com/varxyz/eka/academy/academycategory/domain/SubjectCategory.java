package com.varxyz.eka.academy.academycategory.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class SubjectCategory {

	private long  subjectCategoryId;
	private String subjectCategory;
	private MainSubjectCategory mainSubjectCategory;
	
	public SubjectCategory() {
		
	}
}
