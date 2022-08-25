package com.varxyz.eka.auth.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AcademyManager {
	 
	private long aid;
	private long academyId;
	private String userId;
	private String userPw;
	private String userPw2;
	private String name;
	private String phone;
	private String ssn;
	private String regDate;
	
}
