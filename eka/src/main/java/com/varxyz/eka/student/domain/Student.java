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
	private String phone; // 합친거
	private String phone1; // 010
	private String phone2; // ****
	private String phone3; // ****
	private String ekaUserId;
	private String parentName;
	private String parentType;
	private String parentPhone; // 합친거
	private String parentPhone1; // 010
	private String parentPhone2; // ****
	private String parentPhone3; // ****
	private Date regDate;
	
	private String ekacheck;
	private String gendercheck;
	
	public Student() {
		
	}
	

}
