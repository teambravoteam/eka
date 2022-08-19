package com.varxyz.eka.consulting.service;


import java.util.Date;
import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.consulting.category.domain.ConsultCategory;
import com.varxyz.eka.consulting.domain.Consulting;

/*
 * 상담서비스는 학원관리자가 관리하는 기능들이다 
 * */
public interface ConsultingService {
	
	//학원관리자는 상담정보를 추가할 수 있어야 한다
	public boolean addConsulting(Consulting consulting);
	
	//
	public boolean addApplyConsulting(Consulting consulting);
	
	//
	public boolean addRegistConsulting(Consulting consulting);
	
	//학원관리자는 상담정보를 수정할 수 있어야 한다
	public boolean updateConsulting(Consulting consulting);
	
	//학원관리자는 상담정보를 삭제할  수 있어야 한다
	public boolean deleteConsulting(Consulting consulting);	
	
	/*
	 * 학원관리자는 다양한 상담정보를 확인할 수 있어야 한다.  
	 * */	
	//학원관리자는 모든 상담들을 확인 할 수 있어야 한다.
	public List<Consulting> findAllAcademyConsulting(Academy academy);
	
	// 학원관리자는 모든 상담들을 확인 할 수 있어야 한다.
	public List<Consulting> findAllAcademyApplyConsulting(Academy academy);

	// 학원관리자는 모든 상담들을 확인 할 수 있어야 한다.
	public List<Consulting> findAllAcademyRegistConsulting(Academy academy);
	
	//학원관리자는 특정 개인의 상담 목록을 확인 할 수 있어야 한다
	public List<Consulting> findAcademyConsultingsByName(Academy academy, String name);
	
	//학원관리자는 특정 상담의 카테고리로 상담 목록을 확인 할 수 있어야 한다
	public List<Consulting> findAcademyConsultingsByConsultCategory(Academy academy, ConsultCategory consultCategory);
	
	//학원관리자는 특정 상담 날짜의 상담 기록들을 가져올 수 있어야 한다
	public List<Consulting> findAcademyConsultingsByRegDat(Academy academy, Date regDate);
	
	//학원관리자는 특정 상담 날짜와 이름으로 상담 하나를 가져올 수 있어야 한다
	public Consulting findAcademyConsultingByRegDateAndName(Academy academy, Date regDate, String name);
	
	public Consulting findAcademyApplyConsultingByRegDateAndName(Academy academy, Date regDate, String name);
	
	public Consulting findAcademyRegistConsultingByRegDateAndName(Academy academy, Date regDate, String name);
	
	

}
