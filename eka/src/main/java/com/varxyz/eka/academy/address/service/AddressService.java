package com.varxyz.eka.academy.address.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.varxyz.eka.academy.address.domain.CityAddress;
import com.varxyz.eka.academy.address.domain.CountyAddress;
import com.varxyz.eka.academy.address.repository.AddressDao;

@Component
public class AddressService implements AddressServiceInterface{

	@Autowired
	private AddressDao dao;
	
	
	
	@Override // county 선택후 city 리스트
	public List<CityAddress> checkCountyList(CountyAddress countyAddress) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	// ------------- county --------------------
	
	@Override // county 리스트 불러오기
	public List<CountyAddress> countyList() {
		return dao.countyList();
	}
	
	@Override // county추가
	public boolean addCounty(CountyAddress countyAddress) {
		return dao.addCounty(countyAddress);
	}
	
	@Override // county수정
	public boolean updateCounty(CountyAddress countyAddress, String newCount) {
		return dao.updateCounty(countyAddress, newCount);
	}
	

	
	
	// -------------- city ------------------
	
	
	@Override // city 리스트
	public List<CityAddress> cityList(CountyAddress countyAddress) {
		
		return null;
	}
	
	@Override // city추가
	public boolean addCity(CountyAddress countyAddress, CityAddress cityAddress) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override // city수정
	public boolean updateCity(CountyAddress countyAddress, CityAddress cityAddress,  String newcity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override // city삭제
	public boolean deleteCity(CountyAddress countyAddress, CityAddress cityAddress) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	

}
