package com.varxyz.eka.student.studentcategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.student.studentcategory.command.GradeCategoryCommand;
import com.varxyz.eka.student.studentcategory.domain.SchoolCategory;
import com.varxyz.eka.student.studentcategory.domain.StudentCategory;
import com.varxyz.eka.student.studentcategory.repository.StudentCategoryDao;

@Service
public class StudentCategoryServiceImpl implements StudentCategoryService {
	
	@Autowired
	private StudentCategoryDao dao;
	
	// 학교 카테고리 조회
	public List<SchoolCategory> findSchoolCategory() {
		return dao.findSchoolCategory();
	}
	// 학년 카테고리 조회
	public List<GradeCategoryCommand> findGradeCategory() {
		return dao.findGradeCategory();
	}
	
	
	@Override
	public boolean addStudentCategory(StudentCategory studentCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStudentCategory(StudentCategory studentCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudentCategory(StudentCategory studentCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StudentCategory> findAllStudentCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentCategory> findStudentCategoryByMainCategory(String mainCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentCategory findStudentCategoryBySubCategoryAndMainCategory(String mainCategory, String subCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
