package com.varxyz.eka.score.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ScoreCategory {
	private String lecutrename;
	private String testname;
	private String testdate;
	
	public ScoreCategory() {
		
	}
}
