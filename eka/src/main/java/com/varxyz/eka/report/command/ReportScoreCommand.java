package com.varxyz.eka.report.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ReportScoreCommand {
	
	private String lectureName;
	private String testName;
	private String testDate;
	private double testScore;
	
	public ReportScoreCommand() {
		
	}
}
