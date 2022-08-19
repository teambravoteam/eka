package com.varxyz.eka.academy.academycategory.service;

import java.util.List;


import com.varxyz.eka.academy.academycategory.domain.AgeCategory;
import com.varxyz.eka.academy.academycategory.domain.MainSubjectCategory;
import com.varxyz.eka.academy.academycategory.domain.SubjectCategory;

/*
 * 학원카테고리 시스템은 EKA 관리자가 추가등재, 수정, 삭제, 찾기가 용의 해야합니다
 * */
public interface AcademyCategoryService {

	//EAK 관리자는 연령별 항목을 추가 할 수 있어야 합니다
	public boolean addAgeCategory(AgeCategory ageCategory);
	
	//EAK 관리자는 주요과목 항목을 추가 할 수 있어야 합니다
	public boolean addMainSubjectCategory(MainSubjectCategory mainSubjectCategorty);
		
	//EAK 관리자는 과목 항목을 추가 할 수 있어야 합니다
	public boolean addSubjectCategory(SubjectCategory subjectCategorty);
		
	// EKA 관리자는 연령별 항목을 수정 할 수 있어야 한다
	public boolean updateAgeCategory(AgeCategory ageCategory);

	// EKA 관리자는 주요과목 항목을 수정 할 수 있어야 한다
	public boolean updateMainSubjectCategory(MainSubjectCategory mainSubjectCategorty);

	// EKA 관리자는 과목 항목을 수정 할 수 있어야 한다
	public boolean updateSubjectCategory(SubjectCategory subjectCategorty);
	
	// EKA 관리자는 카테고리 항목을 삭제 할 수 있어야 한다
	public boolean deleteAgeCategory(AgeCategory ageCategory);

	// EKA 관리자는 카테고리 항목을 삭제 할 수 있어야 한다
	public boolean deleteMainSubjectCategory(MainSubjectCategory mainSubjectCategorty);

	// EKA 관리자는 카테고리 항목을 삭제 할 수 있어야 한다
	public boolean deleteSubJectCategory(SubjectCategory subjectCategorty);

	/*
	 * EKA 관리자는 다양한 카테고리 정보를 확인 가능 하여야 한다
	 * */	
	
	//EKA 관리자는 전체 카테고리 항목을 볼 수 있어야 한다
	public List<SubjectCategory> findAllSubjectCategory();
	
	// EKA 관리자는 AGE(연령별)카테고리를 볼 수 있어야 한다
	public List<AgeCategory> findAllAgeCategory();

	// EKA 관리자는 MAINSUBJECT(주요과목)카테고리를 볼 수 있어야 한다
	public List<MainSubjectCategory> findAllMainSubjectCategory();

		
	//EKA 관리자는 특정 카테고리를 찾을 수 있어야 한다.
	public SubjectCategory findAcademyCategoryByName(SubjectCategory subjectCategory);
	
	// EKA 관리자는 주요 과목별로 (주요과목)카테고리를 볼 수 있어야 한다
	public List<SubjectCategory> findSubjectCategoryByMainCategory(String ageCategory);
	
	// EKA 관리자는 연령별로 (주요과목)카테고리를 볼 수 있어야 한다
	public List<SubjectCategory> findSubjectCategoryByAgeCategory(String mainCategory);
	
 }

