package com.varxyz.eka.academy.teacher.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class TeacherListCommand {
	private long tid;
	private long academyId;
	private String name;
	private String gender;
	private String ssn;
	private String phone;
	private String subject;
	private String education;
	private String career;
	private String image;
	private String foreigner;
	
	public TeacherListCommand() {
		
	}
	
}
