package com.varxyz.eka.academy.teacher.domain;

import com.varxyz.eka.academy.academy.domain.Academy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Teacher {
	private long tid;
	private String name;
	private String ssn;
	private String gender;
	private String phone;
	private String subject;
	private String education;
	private String career;
	private String image;
	private String foreigner;
	private Academy academy;
	
	public Teacher() {
		
	}

}
