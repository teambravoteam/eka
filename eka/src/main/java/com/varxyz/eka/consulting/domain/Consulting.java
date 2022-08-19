package com.varxyz.eka.consulting.domain;



import java.util.Date;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.consulting.category.domain.ConsultCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor  
public class Consulting {
	private long cid;
	private String name;
	private String phone;
	private String phone1;
	private String phone2;
	private String phone3;
	private Academy academy;
	private ConsultCategory consultCategory;
	private String consultDatail;
	private String consultContent;
	private String applyDate;
	private String registDate;
	private String ConsultType;
	
	
	public Consulting() {
		
	}

}
