package com.varxyz.eka.score.command;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ScoreCommand {
	private long asid;
	private long academyId;
	private String lectureName;
	private String testScore;
	
	
	
}
