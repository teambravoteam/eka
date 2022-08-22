package com.varxyz.eka.academy.academy.service;

import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;

public interface AcademyService {
	
	//모든 학원 리스트를 가져와야한다.
	public List<Academy> findAllAcademies();
	
	//카테고리로 학원 리스트를 가져옴
	public List<Academy> findAcademiesByCategory(String field2);
	
	//주소별로 학원 리스트를 가져올 수 있어야 한다
	public List<Academy> findAcademiesByAddress(String address);
	
}
