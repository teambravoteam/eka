package com.varxyz.eka.student.domain;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {
	
	private long sid;
	private long academyId;
	private String schoolcate;
	private String gradecate;
	private	String name;
	private String gender;
	private Date ssn;
	private String phone;
	private boolean ekaSignUp;
	private String parentName;
	private String parentType;
	private String parentPhone;
	private Time regDate;
	
	public Student() {
		
	}
	

}
