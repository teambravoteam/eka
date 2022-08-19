package com.varxyz.eka.student.studentcategory.service;

import java.util.List;

import com.varxyz.eka.student.studentcategory.domain.StudentCategory;

/*
 * EKA 관리자는 학생에 대한 학생 카테고리를 관리해야한다
 * */
public interface StudentCategoryService {
	// EKA 관리자는 학생 카테고리를 등록할 수 있어야 한다
	public boolean addStudentCategory(StudentCategory studentCategory);

	// EKA 관리자는 학생 카테고리를 수정할 수 있어야 한다
	public boolean updateStudentCategory(StudentCategory studentCategory);

	// EKA 관리자는 학생 카테고리를 삭제할 수 있어야 한다
	public boolean deleteStudentCategory(StudentCategory studentCategory);
	
	
	/*
	 * EKA 관리자는 학생 카테고리를 조회할 수 있어야 한다
	 * */
	
	//EKA 관리자는 모든 학생 카테고리를 조회할 수 있다
	public List<StudentCategory> findAllStudentCategory();
	
	//EKA 관리자는 STUDENTMAINCATEGORY(초/중/고/대학/일반)별 카테고리를 조회 할 수 있다
	public List<StudentCategory> findStudentCategoryByMainCategory(String mainCategory);
	
	//EKA 관리자는 STUDENTSUBCATEGORY와 MAINCATEOGRY 인해 카테고리 하나를 조회할 수 있다
	public StudentCategory findStudentCategoryBySubCategoryAndMainCategory
	(String mainCategory, String subCategory);
	
	
	

}
