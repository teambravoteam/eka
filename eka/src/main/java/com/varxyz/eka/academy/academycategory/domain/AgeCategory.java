package com.varxyz.eka.academy.academycategory.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AgeCategory {
	private long ageCategoryId;
	private String ageCate;

	public AgeCategory() {
		
	}
}
