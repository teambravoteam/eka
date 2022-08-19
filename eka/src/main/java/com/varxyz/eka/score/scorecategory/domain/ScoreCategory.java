package com.varxyz.eka.score.scorecategory.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ScoreCategory {
	private String areaCategory;
	private String testTypeCategory;
	private String subjectCategory;
	
	public ScoreCategory() {
		
	}
}
