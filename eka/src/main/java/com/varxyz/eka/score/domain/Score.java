package com.varxyz.eka.score.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Score {
	private long asid;
	private long academyId;	
	private String lecturename;
	private String testname;
	private Date testdate;
	private long studentId;
	private double testScore;
	
	public Score() 	{
		
	}

}
