package com.varxyz.eka.academy.address.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Address {
	private long addressId;
	private String countyAddress;
	private String cityAddress;
	public Address() {
		
	}

}
