package com.varxyz.eka.score.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ScoreCategory {
	private long atcid;
	private long academyId;
	private String lectureName;
	private String testName;
	private String testDate;
	
	public ScoreCategory() {
	}
}
