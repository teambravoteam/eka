package com.varxyz.eka.academy.academy.service;

import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.student.domain.Student;

public interface AcademyService {
	//학원 정보를 업데이트 할 수 있어야한다.
	public void signEkaAcademy(Academy academy);
	
	//모든 학원 리스트를 가져와야한다.
	public List<Academy> findAllAcademies();
	
	//카테고리로 학원 리스트를 가져옴
	public List<Academy> findAcademiesByCategory(String field2);
	
	//주소별로 학원 리스트를 가져올 수 있어야 한다
	public List<Academy> findAcademiesByAddress(String address);
	
	//주소와 이름로 학원 정보를 가져올 수 있어야 한다
	public Academy findAcademyByAddressAndName(String address, String name);
	
	//Aid로 학원 정보를 가져올 수 있어야 한다
	public Academy findAcademyByAid(long aid);
	
	//ekauserId로 student 정보를 가져올 수 있어야 한다
	public Student findStudentByEkaUserId(String ekaUserId);

	//ekauserId로 student 정보 여러개를 가져올 수 있어야 한다
	public List<Student> findStudentsByEkaUserId(String ekaUserId);
}
