package com.varxyz.eka.academy.lecture.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor 
@ToString
public class LectureStudentCommand {
	private long sid;
	private String name;
	private double score;
	
	public LectureStudentCommand() {
		
	}
}
