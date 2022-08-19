package com.varxyz.eka.academy.academycategory.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MainSubjectCategory {
		
	private AgeCategory ageCategory;
	private long mainCategoryId;
	private String mainCate;
	
	public MainSubjectCategory() {
		
	}

}
