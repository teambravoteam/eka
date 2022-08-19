package com.varxyz.eka.academy.academy.domain;

import java.sql.Date;
import java.sql.Time;

import com.varxyz.eka.academy.academycategory.domain.SubjectCategory;
import com.varxyz.eka.academy.address.domain.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class Academy {
	private long aid;
	private String name;
	private Date openingday;
	private String address;
	private String detailaddress;
	private String lat;
	private String lon;
	private Long personnel;
	private String field1;
	private String field2;
	private String field3;
	private String field4;
	private String[] priceList;
	private String phone;
	private String introduction;
	private String[] academyservice;
	private String[] runday;
	private Time startruntime;
	private Time endruntime;
	private String[] consultableday;
	private Time startconsultabletime;
	private Time endconsultabletime;
	private String signedacademy;

	
	public Academy() {
		
	}
}
