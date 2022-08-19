package com.varxyz.eka.academy.address.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class CountyAddress {

	private long countyId;
	private String county;
	
	public CountyAddress() {
		
	}
	
	public String toString() {
		return countyId + "," + county; 
	}
}
