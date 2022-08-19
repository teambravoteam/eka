package com.varxyz.eka.academyscore.category.service;

import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academyscore.category.domain.AcademyTestCategory;


public interface AcademyTestCategoryService {
	//학원관리자는 점수카테고리정보를 등록합니다
	public boolean addCategory(AcademyTestCategory academycategory);
	
	//학원관리자는 점수카테고리정보를 수정합니다.
	public boolean updateCategory(AcademyTestCategory academycategory);
	
	//학원관리자는 점수카테고리정보를 삭제합니다
	public boolean deleteCategory(AcademyTestCategory academycategory);
	
	/*
	 * 학원 관리자는 다양한 점수카테고리정보를 조회할수 있습니다.
	 * */		
	
	//학원관리자는 학원의 모든 학원점수카테고리정보를 알 수 있다.
	public List<AcademyTestCategory> findAllAcademyTestCategory(Academy academy);
	
	//학원관리자는 학원 의 강의별 학원점수카테고리정보를 알 수 있다.
	public List<AcademyTestCategory> findAllAcademyTestCategoryByLecture(Academy academy, Lecture lecture);
	
}
