package com.varxyz.eka.academy.address.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class CityAddress {
	
	private long cityId;
	private String city;
	private CountyAddress countyAddress;
	
	public CityAddress() {
		
	}
	
	
}
