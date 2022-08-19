package com.varxyz.eka.academy.address.service;

import java.util.List;

import com.varxyz.eka.academy.address.domain.CityAddress;
import com.varxyz.eka.academy.address.domain.CountyAddress;

public interface AddressServiceInterface {
	
	
	// county 선택후 city 리스트
	public List<CityAddress> checkCountyList(CountyAddress countyAddress);
	

	// ------------- county --------------------
	
	
	// county 리스트
	public List<CountyAddress> countyList();
	
	// county추가
	public boolean addCounty(CountyAddress countyAddress);
	
	// county수정
	public boolean updateCounty(CountyAddress countyAddress, String newCount);
	
	
	// -------------- city ------------------
	
	
	// city 리스트
	public List<CityAddress> cityList(CountyAddress countyAddress);
	
	// city추가
	public boolean addCity(CountyAddress countyAddress, CityAddress cityAddress);
	
	// city수정
	public boolean updateCity(CountyAddress countyAddress, CityAddress cityAddress, String newcity);
	
	// city삭제
	public boolean deleteCity(CountyAddress countyAddress, CityAddress cityAddress);
	
	
	 
	
	
}
